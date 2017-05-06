package com.latewind.practice.concurrent.base;

public class ThreadRunner {

	public static void main(String[] args) {
		ProductQueue queue = new ProductQueue();
		MonitorThread mt = MonitorThread.getInstance(queue);

		run(mt);
		

	}

	public static void run(Runnable thread) {

		new Thread(thread).start();
	}

}
