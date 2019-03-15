package com.latewind.practice.concurrent.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Memoizer2<A, V> implements Computable<A, V> {
    private final Map<A, V> cache = new ConcurrentHashMap<>();
    private final Computable<A, V> c;

    public Memoizer2(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public V compute(A args) throws InterruptedException {
        V result = cache.get(args);
        //多个线程走到为空的逻辑，会重复计算
        if (result == null) {
            result = c.compute(args);
            cache.put(args, result);
        }
        return null;
    }
}
