package com.latewind.practice.concurrent.pool;

/**
 * Created by Late Wind on 2017/5/21.
 */
public class PortThread extends Thread {
    public PortThread(String s, Runnable r) {
        super(r, s);
    }

    @Override
    public void run() {
        System.out.println("start thread"+this.getName());
        super.run();
        System.out.println("end thread "+this.getName());
    }
}
