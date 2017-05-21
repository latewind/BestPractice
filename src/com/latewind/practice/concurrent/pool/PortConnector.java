package com.latewind.practice.concurrent.pool;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.*;

/**
 * Created by Late Wind on 2017/5/21.
 */
public class PortConnector {
    static final int PORT_MAX_RANGE=65535;
    BlockingQueue<Runnable> workQueue=new LinkedBlockingQueue<>();
    ThreadFactory threadFactory=new PortThreadFactory();
    private CopyOnWriteArrayList<Integer> ports=new CopyOnWriteArrayList<>();
    static final int POOL_SIZE=50;
    static final int MAX_POOL_SIZE=100;
    static final int KEEP_ALIVE_TIME=10;
    String ip="124.128.62.162";
    ExecutorService service= new ThreadPoolExecutor(POOL_SIZE,
                                                    MAX_POOL_SIZE,
                                                    KEEP_ALIVE_TIME,
                                                    TimeUnit.SECONDS,workQueue,threadFactory);

    public void run(){
        service.submit(()->{
               try {
                   while(!Thread.currentThread().isInterrupted()) {
                       System.out.println("size"+workQueue.size());
                       Thread.sleep(10000);
                   }
                   } catch (InterruptedException e) {
                   e.printStackTrace();
           }
        });
        for(int i=0;i<PORT_MAX_RANGE;i++) {
            int finalI = i;
            service.submit(() -> {
                Socket client = null;
                try {
                    client=new Socket(ip,Integer.valueOf(finalI));
                } catch (IOException e) {
                  //  System.out.println("close port:"+finalI);
                    return ;
                }
                try {
                   System.out.println("open port:"+finalI);
                    ports.add(finalI);
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }



    public static void main(String args[]){
    new PortConnector().run();

    }

}


