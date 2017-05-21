package com.latewind.practice.concurrent.cancel;

import com.latewind.practice.tools.Maths;

import java.util.concurrent.*;

/**
 * Created by Late Wind on 2017/5/20.
 */
public class PasswdEncrypt {
    static ExecutorService service = Executors.newCachedThreadPool();

    public static void main(String args[]) throws InterruptedException {

        PasswdEncrypt passwdEncrypt=new PasswdEncrypt();
        for(int i=0;i<10;i++) {

            service.submit(()->{
                System.out.println(passwdEncrypt.encrypt());
            });

        }
        Thread.sleep(3000);
        service.shutdown();
    }
    public Integer encrypt(){
        Future<Integer> task=service.submit(new enctypterTask());
        Integer result=null;
        System.out.println("waitting");
        try {
          result=  task.get(1,TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }finally {
            task.cancel(true);
        }
     return result;
    }

    class enctypterTask implements Callable{

        @Override
        public Object call() throws Exception {
            System.out.println("running");
            int i=Maths.nextRandomInt(2000);
            Thread.sleep(i);
            return new Integer(i);
        }
    }
}
