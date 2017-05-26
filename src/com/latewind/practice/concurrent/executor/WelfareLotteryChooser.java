package com.latewind.practice.concurrent.executor;

import com.latewind.practice.tools.Maths;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * Created by Late Wind  on 2017/5/18.
 */
public class WelfareLotteryChooser {
    final static int THREAD_COUNT=5;
    private static final int CHOOSE_TIMES = 10;
    Executor executor = Executors.newFixedThreadPool(5);
    CompletionService service=new ExecutorCompletionService(executor);

    public static void  main(String [] args){
        try {
            new WelfareLotteryChooser().showResult();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }


    public void showResult() throws InterruptedException, ExecutionException {

        chooseRed();
        for(int i=0;i<CHOOSE_TIMES;i++) {
            Future<String> f=service.take();

            String redResult=f.get();
            System.out.println(redResult+":"+chooseBlue());
        }
    }

    private String chooseBlue() {
        Integer blueBall= Maths.nextRandomInt(16)+1;
        return  blueBall.toString();
    }


    private void chooseRed(){
        for(int i=0;i<CHOOSE_TIMES;i++) {
            service.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
               //     System.out.println("running");
                    return getRedBall();
                }
            });
        }
    }

    private String getRedBall() throws InterruptedException {
        ArrayList<Integer> balls=new ArrayList<>(6);
       Long start= System.currentTimeMillis();
        while(balls.size()<6){
            Integer redBall= Maths.nextRandomInt(33)+1;
            if(!balls.contains(redBall)){
                Thread.sleep(Maths.nextRandomInt(3000));
                balls.add(redBall);
            }

        }
        System.out.println(System.currentTimeMillis()-start);
        return balls.toString();
    }



}
