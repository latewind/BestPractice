package com.latewind.practice.concurrent.container;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import com.latewind.practice.concurrent.base.Product;

public class ProducerConsumer {
	BlockingQueue<Product> queue=new LinkedBlockingQueue<>(100);
	public int INTERVAL_TIME=3000;
	protected Random random =new Random();
	public  void start(){
		for(int i=0;i<5;i++){
			
			new Thread(new Producer()).start();
			new Thread(new Consumer()).start();
			
		}
		
	}
	public static void main(String[] args) {
		
		new ProducerConsumer().start();
		
	}
	class Producer implements Runnable{

		@Override
		public void run() {
			
			while(true){
			try {
				Thread.sleep(random.nextInt(INTERVAL_TIME));
				queue.put(new Product(Thread.currentThread().getName()+"_P"));
				System.out.println();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			}
		}
		
	}
	
	
	class Consumer implements Runnable{

		@Override
		public void run() {
			while(true){
				
				try {
					Thread.sleep(random.nextInt(INTERVAL_TIME));
					System.out.println(queue.take()+Thread.currentThread().getName()+"_C");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}
