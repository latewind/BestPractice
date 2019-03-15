package com.latewind.test.practice.concurrent.cache;

import com.latewind.practice.concurrent.cache.ExpensiveFunction;
import com.latewind.practice.concurrent.cache.Memoizer;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

public class SharedCacheTest {

    @Test
    public void testMemoizer() throws Exception {
        Memoizer<String, BigInteger> memoizer = new Memoizer<>(new ExpensiveFunction());
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    memoizer.compute("1");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
        memoizer.compute("1");


    }
}