package com.latewind.practice.concurrent.tools;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Race {
	static final int RUNNER_COUNT = 10;
	private CountDownLatch start = new CountDownLatch(1);
	private CountDownLatch end = new CountDownLatch(RUNNER_COUNT);
	public int INTERVAL_TIME = 3000;
	protected Random random = new Random();

	public void startRace() {
		for (int i = 0; i < RUNNER_COUNT; i++) {
			new Thread(new Runner()).start();
		}
		System.out.println("Start Race");
		long startTIme = System.currentTimeMillis();
		start.countDown();//信号量-1，开启
		try {
			end.await();//等待，知道信号为0
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Race End use:" + (endTime - startTIme));

	}

	public static void main(String[] args) {

		new Race().startRace();

	}

	class Runner implements Runnable {

		@Override
		public void run() {
			try {
				start.await();
				System.out.println(Thread.currentThread().getName() + ":I'm running");
				int useTime = random.nextInt(INTERVAL_TIME);
				Thread.sleep(useTime);
				System.out.println(Thread.currentThread().getName() + ":I have arrived use:" + useTime);
				end.countDown();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}