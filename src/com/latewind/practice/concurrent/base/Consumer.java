package com.latewind.practice.concurrent.base;

import java.util.Random;

public class Consumer extends BaseThread{
   
	public Consumer(ProductQueue queue) {
		super(queue);
	}

	@Override
	public void run() {
		while(true){
			
			try {
				Thread.sleep(random.nextInt(1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println("I get a :"+queue.get());
		}
	}

}
