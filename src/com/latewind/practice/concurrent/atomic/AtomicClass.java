package com.latewind.practice.concurrent.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicClass extends Thread {
    private static AtomicInteger count = new AtomicInteger(0);

    @Override
    public void run() {
        while (true) {

            count.incrementAndGet();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
