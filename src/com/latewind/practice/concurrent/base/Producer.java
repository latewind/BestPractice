package com.latewind.practice.concurrent.base;

import java.util.concurrent.atomic.AtomicInteger;

public class Producer extends BaseThread{
	private static AtomicInteger count=new AtomicInteger(0);

	public Producer(ProductQueue queue) {
		super(queue);
	}

	@Override
	public void run() {
		while(true){
		
		queue.put(new Product("product:"+count.incrementAndGet()+" by "+Thread.currentThread().getName()));
		try {
			Thread.sleep(random.nextInt(2000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
			
		}
	}

}
