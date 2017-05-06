package com.latewind.practice.concurrent.base;

import java.util.Random;

public class Consumer extends BaseThread{
   
	public Consumer(ProductQueue queue) {
		super(queue);
	}

	@Override
	public void run() {
		while(canRun){
			
			try {
				Thread.sleep(random.nextInt(INTERVAL_TIME));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println(Thread.currentThread().getName()+"  I get a :"+queue.get());
		}
	}

}
