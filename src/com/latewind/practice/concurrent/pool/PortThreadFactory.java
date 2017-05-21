package com.latewind.practice.concurrent.pool;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Late Wind on 2017/5/21.
 */
public class PortThreadFactory implements ThreadFactory{
    AtomicInteger count=new AtomicInteger(0);
    @Override
    public Thread newThread(Runnable r) {
        return new PortThread(count.getAndIncrement()+"thread",r);
    }
}
