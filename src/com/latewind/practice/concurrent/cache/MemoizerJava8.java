package com.latewind.practice.concurrent.cache;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;

public class MemoizerJava8<A, V> implements Computable<A, V> {
    private final ConcurrentMap<A, V> cache = new ConcurrentHashMap<>();
    private final Computable<A, V> c;

    public MemoizerJava8(Computable<A, V> c) {
        this.c = c;
    }

    /**
     * java 8 中新增computeIfAbsent方法来实现没有的情况下来计算，
     * 将耗时的操作放到 function里面
     * @param args
     * @return
     * @throws InterruptedException
     */
    @Override
    public V compute(A args) throws InterruptedException {
        return cache.computeIfAbsent(args, new Function<A, V>() {
            @Override
            public V apply(A a) {
                while (true) {
                    try {
                        return c.compute(a);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        });
    }

}
