package com.latewind.practice.concurrent.cache;

import java.math.BigInteger;
import java.util.concurrent.*;

public class Memoizer<A, V> implements Computable<A, V> {
    private final Computable<A, V> c;
    private final ConcurrentMap<A, Future<V>> cache = new ConcurrentHashMap<>();

    public Memoizer(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public V compute(A args) throws Exception {
        Future<V> f = cache.get(args);
        if (f == null) {
            Callable<V> callable = new Callable<V>() {
                @Override
                public V call() throws Exception {
                    return c.compute(args);
                }
            };
            FutureTask<V> ft = new FutureTask<>(callable);
            f = cache.putIfAbsent(args, ft);
            if (null == f) {
                f = ft;
                ft.run();//执行下任务（必须）
            }
        }
        return f.get();
    }

    public static void main(String[] args) throws Exception {
        Memoizer<String, BigInteger> memoizer = new Memoizer<>(new ExpensiveFunction());
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(memoizer.compute("1"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        memoizer.compute("1");


    }

}


