package com.latewind.practice.concurrent.cancel;

import java.io.File;
import java.io.IOException;

/**
 * Use the Exit function
 * in the IDE not the Stop
 * Created by Late Wind on 2017/5/27.
 */
public class TestShutDownHook {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // 定义线程1
        Thread thread1 = new Thread() {
            public void run() {
                System.out.println("thread1...");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        // 定义线程2
        Thread thread2 = new Thread() {
            public void run() {
                System.out.println("thread2...");
            }
        };

        // 定义关闭线程
        Thread shutdownThread = new Thread() {
            public void run() {
                System.out.println("shutdownThread...");
            }
        };

        // jvm关闭的时候先执行该线程钩子
        Runtime.getRuntime().addShutdownHook(shutdownThread);

        thread1.start();
        thread2.start();
        ;
    }
}
