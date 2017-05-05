package com.latewind.practice.concurrent.base;

public class ThreadRunner {
	
	public static void main(String[] args) {
		ProductQueue queue=new ProductQueue();
		Consumer ca=new Consumer(queue);
		Consumer cb=new Consumer(queue);
		Producer pa=new Producer(queue);
		Producer pb=new Producer(queue);
	
		
		ThreadRunner.run(ca);
		ThreadRunner.run(cb);
		ThreadRunner.run(pa);
		ThreadRunner.run(pb);
		
		
		
	}
	
	public static void run(Runnable thread){
		
		new Thread(thread).start();
	}
	
	
	

}
