package com.latewind.practice.zk;

import com.alibaba.fastjson.JSONObject;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class TaskDispatcher extends Thread {
    CuratorFramework client;
    private InterProcessMutex interProcessMutex;  //可重入排它锁
    private String pathNode;

    public TaskDispatcher(CuratorFramework curatorFramework, String taskNode) {
        this.client = curatorFramework;
        this.pathNode = taskNode;

    }

    public TaskDispatcher init(){
        interProcessMutex = new InterProcessMutex(client, pathNode);
        return this;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("try");
            try {
                if (interProcessMutex.acquire(2, TimeUnit.SECONDS)) {
                    try {
                        dispatch();

                    } finally {
                        interProcessMutex.release();
                    }

                    Thread.sleep(2000);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    private void dispatch() {
        if (client != null) {
            String uuid = UUID.randomUUID().toString();
            JSONObject task = new JSONObject();
            task.put("status", "todo");
            task.put("name", uuid);
            String data = task.toJSONString();
            try {
                client.create().forPath(pathNode + "/" + uuid, data.getBytes());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        String ZK_URL = "127.0.0.1:2181";

        CuratorFramework curatorFramework = CuratorFrameworkFactory.newClient(ZK_URL, new ExponentialBackoffRetry(1000, 3));
        curatorFramework.start();
        new TaskDispatcher(curatorFramework,"/distributed/lock/tasks").init().start();


    }

}
