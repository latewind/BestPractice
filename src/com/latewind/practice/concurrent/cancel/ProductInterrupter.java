package com.latewind.practice.concurrent.cancel;

import com.latewind.practice.concurrent.base.Product;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Late Wind on 2017/5/20.
 */
public class ProductInterrupter {
   private static AtomicInteger count=new AtomicInteger(0);
   private static BlockingQueue<Product> products=new LinkedBlockingDeque<>(100);

   public static void main(String args[]) throws InterruptedException {
       Thread producterThread=new Thread(new PrimeProducter());
       Thread consumerThread=new Thread(new PrimeConsumer());
       producterThread.start();
       consumerThread.start();
       Thread.sleep(2000);
       consumerThread.interrupt();
       producterThread.interrupt();

       Thread.sleep(2000);
   }

    static class PrimeProducter implements Runnable{

        @Override
        public void run() {
            try {
            while(!Thread.currentThread().isInterrupted()){
                    Product product=products.take();
                    System.out.println(product);
            }
                } catch (InterruptedException e) {
                    System.out.println("Product.cancel");
                    e.printStackTrace();
                }
            System.out.println("Producter over");
        }
    }
    static class PrimeConsumer implements Runnable{
        @Override
        public void run() {
                try {
                    while(!Thread.currentThread().isInterrupted()){ // while statement must inner the try statement
                    products.put(new Product(String.valueOf(count.addAndGet(1))));
                    }
                } catch (InterruptedException e) {
                    System.out.println("Consumer Cancel");
                    e.printStackTrace();
                }
            System.out.println("Consumer over");
        }
    }


}
