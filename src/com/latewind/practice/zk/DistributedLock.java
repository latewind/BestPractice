package com.latewind.practice.zk;


import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * classname：DistributedLock
 * desc：基于zookeeper的开源客户端Cruator实现分布式锁
 * author：simonsfan
 */
public class DistributedLock {
    public static Logger log = LoggerFactory.getLogger(DistributedLock.class);
    private InterProcessMutex interProcessMutex;  //可重入排它锁
    private String lockName;  //竞争资源标志
    private String root = "/distributed/lock/";//根节点
    private  CuratorFramework curatorFramework;
    private static String ZK_URL = "127.0.0.1:2181";



    /**
     * 实例化
     *
     * @param lockName
     */
    public DistributedLock(String lockName) {
        try {
            curatorFramework = CuratorFrameworkFactory.newClient(ZK_URL, new ExponentialBackoffRetry(1000, 3));
            curatorFramework.start();
            this.lockName = lockName;
            interProcessMutex = new InterProcessMutex(curatorFramework, root + lockName);
        } catch (Exception e) {
            log.error("initial InterProcessMutex exception=" + e);
        }
    }

    /**
     * 获取锁
     */
    public boolean acquireLock() {

        int flag = 0;
        try {
            //重试2次，每次最大等待2s，也就是最大等待4s
            while (!interProcessMutex.acquire(2, TimeUnit.SECONDS)) {
                flag++;
                if (flag > 1) {  //重试两次
                    break;
                }
            }
        } catch (Exception e) {
            log.error("distributed lock acquire exception=" + e);
        }
//        log.info(interProcessMutex.);
        if (flag > 1) {
            log.info("Thread:" + Thread.currentThread().getId() + " acquire distributed lock  busy");
            System.out.println("busy");
            return false;
        } else {

            log.info("Thread:" + Thread.currentThread().getId() + " acquire distributed lock  success");
            System.out.println("success");
            return true;
        }
    }

    /**
     * 释放锁
     */
    public void releaseLock() {
        try {
            if (interProcessMutex != null && interProcessMutex.isAcquiredInThisProcess()) {
                interProcessMutex.release();
                curatorFramework.delete().forPath(root + lockName);
//                curatorFramework.close();

                log.info("Thread:" + Thread.currentThread().getId() + " release distributed lock  success");
            }
        } catch (Exception e) {
            log.info("Thread:" + Thread.currentThread().getId() + " release distributed lock  exception=" + e);
        }
    }


    public static void main(String[] args) throws InterruptedException {
        CuratorFramework curatorFramework = CuratorFrameworkFactory.newClient(ZK_URL, new ExponentialBackoffRetry(1000, 3));
        curatorFramework.start();
        new TaskDispatcher(curatorFramework,"/distributed/lock/tasks").init().start();
        int i = 0;
        DistributedLock d = new DistributedLock("abc");
        boolean ready = true;
        boolean status = false;
        while (true) {

            if(d.acquireLock()){
                System.out.println("get it");
                Thread.sleep(10000);
                d.releaseLock();
            }

            System.out.println("sleep");
            Thread.sleep(2000);
        }
    }

}