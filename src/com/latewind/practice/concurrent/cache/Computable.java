package com.latewind.practice.concurrent.cache;

import java.util.concurrent.ExecutionException;

public interface Computable<A, V> {
    V compute(A args) throws Exception;
}
