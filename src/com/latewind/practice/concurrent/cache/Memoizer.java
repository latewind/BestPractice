package com.latewind.practice.concurrent.cache;

import java.math.BigInteger;
import java.util.concurrent.*;


public class Memoizer<A, V> implements Computable<A, V> {
    private final Computable<A, V> c;
    private final ConcurrentMap<A, Future<V>> cache = new ConcurrentHashMap<>();

    /**
     * 采用future 的方式将耗时的操作放在 futute里面
     * 用future来保证concurrentMap里面的唯一性
     *
     * @param args
     * @return
     * @throws InterruptedException
     */
    @Override
    public V compute(A args) throws InterruptedException {
        while (true) { // 加循环的作用，当cancle 发生的时候，再重新get
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
                //多个线程走到上面的putIfAbsent的时候，只有一个能put进去，并且返回原先null，如果原先存在，返回原先的
                if (null == f) {
                    f = ft;
                    ft.run();//执行下任务（必须）
                }
            }
            try {
                return f.get();
            } catch (CancellationException e) {//cancle的时候，即run的过程没有结束，取消cache里面对应的future 防止污染
                cache.remove(args, f);
            } catch (ExecutionException e) {
                throw new InterruptedException();
            }
        }
    }

    public Memoizer(Computable<A, V> c) {
        this.c = c;
    }

    public static void main(String[] args) throws Exception {
        Memoizer<String, BigInteger> memoizer = new Memoizer<>(new ExpensiveFunction());
        new Thread(() -> {
            try {
                System.out.println(memoizer.compute("1"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        memoizer.compute("1");


    }

}


