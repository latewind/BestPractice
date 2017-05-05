package com.latewind.practice.concurrent.base;

public class MonitorThread extends BaseThread{

	public MonitorThread(ProductQueue queue) {
		super(queue);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {

		while(true){
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(queue.getSize());
		}
	}

}
