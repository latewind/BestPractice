package com.latewind.practice.concurrent.tools;

import com.latewind.practice.tools.Maths;

import java.util.concurrent.Semaphore;

/**
 *
 */
public class BusStation {
	Toilet toilet = new Toilet();

	public static void main(String[] args) {
		new BusStation().start();

	}

	public void start() {

		for (int i = 0; i < 100; i++) {
			new Thread(new Passenger("NO." + i, toilet)).start();
		}

	}

	class Toilet {
		private static final int MAX_CAPACITY = 10;
		Semaphore semaphore = new Semaphore(MAX_CAPACITY);

		public void getOn(Passenger passenger) {
			try {
				semaphore.acquire();
				System.out.println(passenger.name + " Into the Toilent");
				Thread.sleep(Maths.nextRandomInt(10000));
				semaphore.release();
				System.out.println(passenger.name + " I'm OK");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	class Passenger implements Runnable {
		String name;
		Toilet toilet;

		public Passenger(String name, Toilet toilet) {
			this.name = name;
			this.toilet = toilet;
		}

		@Override
		public void run() {
			toilet.getOn(this);
		}
	}

}
