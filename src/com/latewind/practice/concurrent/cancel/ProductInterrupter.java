package com.latewind.practice.concurrent.cancel;

import com.latewind.practice.concurrent.base.Product;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Producer and Consumer will be invoked cancel() method after they have ran  2 second
 * notice that:if the while statement was surrounded by try statement,this thread will be interrupted,
 * otherwise this thread will still running
 *
 * Created by Late Wind on 2017/5/20.
 */
public class ProductInterrupter {
   private static AtomicInteger count=new AtomicInteger(0);
   private static BlockingQueue<Product> products=new LinkedBlockingDeque<>(10000);

   public static void main(String args[]) throws InterruptedException {
       Thread producterThread=new Thread(new PrimeProducerInner());
       Thread consumerThread=new Thread(new PrimeConsumer());
       producterThread.start();
       consumerThread.start();
       Thread.sleep(2000);
       consumerThread.interrupt();
       producterThread.interrupt();

       Thread.sleep(2000);
       consumerThread=new Thread(new PrimeConsumer());
       consumerThread.start();
   }

    static class PrimeConsumer implements Runnable{

        @Override
        public void run() {
            try {
            while(!Thread.currentThread().isInterrupted()){
                    Product product=products.take();
                    Thread.sleep(50);
                    System.out.println(product);
            }
                } catch (InterruptedException e) {
                    System.out.println("PrimeConsumer.cancel");
                    e.printStackTrace();
                }

            System.out.println("PrimeConsumer over:"+Thread.currentThread().isInterrupted());
        }
    }
    static class  PrimeProducer implements Runnable{
        @Override
        public void run() {
                try {
                    while(!Thread.currentThread().isInterrupted()){ // while statement must inner the try statement
                    products.put(new Product(String.valueOf(count.addAndGet(1))));

                    }
                } catch (InterruptedException e) {
                    System.out.println("PrimeProducer Cancel");
                    e.printStackTrace();
                }
            System.out.println("PrimeProducer over");
        }
    }

    static class PrimeProducerInner implements Runnable{
        @Override
        public void run() {

                while(!Thread.currentThread().isInterrupted()){ // while statement must inner the try statement
                    try {

                        products.put(new Product(String.valueOf(count.addAndGet(1))));
                    //    System.out.println("put");

                    } catch (InterruptedException e) {
                        System.out.println("PrimeProducerInner Cancel");
                    ///    Thread.currentThread().interrupt();
                    //    Thread.interrupted();
                        e.printStackTrace();
                    }

                }

        //    System.out.println("Consumer over");
        }
    }



}
