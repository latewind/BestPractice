package com.latewind.practice.concurrent.state;

public class ThreadMethod {

	public void testJoin() {
		SubThread threadA = new SubThread("A");
		SubThread threadB = new SubThread("B");
		threadA.start();
		threadB.start();
		try {

			Thread.sleep(5000);
			System.out.println("start join");
			threadA.yourFist(threadB);
			Thread.sleep(10000);
			System.out.println("end main");

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	class SubThread extends Thread {
		private Thread otherThread;
		private boolean allowJoin = false;

		public SubThread(String name) {
			super(name);
		}

		public void yourFist(Thread thread) {
			otherThread = thread;
			allowJoin = true;

		}

		@Override
		public void run() {
			int i = 0;

			try {
				while (i <= 20) {
					System.out.println(this.getName() + " is running");
					i++;
					if (allowJoin()) {
						System.out.println("start join");
							otherThread.join();
					}
					Thread.sleep(1000);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		private boolean allowJoin() {
			return allowJoin;
		}

	}

	public static void main(String[] args) {
		new ThreadMethod().testJoin();
	}
}
