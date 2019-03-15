package com.latewind.practice.concurrent.cache;

import java.util.HashMap;
import java.util.Map;

public class Memoizer1<A, V> implements Computable<A, V> {
    private final Map<A, V> cache = new HashMap<>();
    private final Computable<A, V> c;

    public Memoizer1(Computable<A, V> c) {
        this.c = c;
    }

    //同步整个方法，导致效率低
    @Override
    public synchronized V compute(A args) {
        V result = cache.get(args);
        if (result == null) {
            try {
                result = c.compute(args);
            } catch (Exception e) {
                e.printStackTrace();
            }
            cache.put(args, result);
        }
        return result;
    }
}
