package com.latewind.practice.concurrent.tools;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

import com.latewind.practice.tools.Maths;

public class CarFactory {
	final int WORKER_COUNT=2;
	CyclicBarrier barrier;
	CarBuilder builder=new CarBuilder();
	 Worker[] workers =new Worker[WORKER_COUNT];
	
	public CarFactory() {
		barrier=new CyclicBarrier(WORKER_COUNT,new Runnable() {
			
			@Override
			public void run() {
				
				builder.compose();
			}
		});
		
	}
	
	public void start(){
		
		workers[0]=new Worker("buildWheel");
		workers[1]=new Worker("buildBody");
		for(int i=0;i<WORKER_COUNT;i++){
			new Thread(workers[i]).start();
		}
	}
	
	public static void main(String[] args) {
		new CarFactory().start();
	}

	class Worker implements Runnable {
		String job;
		Method jobMethod;
		public Worker(String job) {
			this.job=job;
	
				try {
					jobMethod=CarBuilder.class.getDeclaredMethod(job);
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		}
		@Override
		public void run() {

			try {
				while (true) {
					
					Thread.sleep(Maths.nextRandomInt(5000));
					jobMethod.invoke(builder);
					barrier.await();

				}

			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	class CarBuilder {
		AtomicInteger count=new AtomicInteger(0);
		String wheel;
		String body;

		public void buildWheel() {
			wheel = "Big Wheel";
			System.out.println("Build Wheel...");
		}

		public void buildBody() {
			body = "Cool Body";
			System.out.println("Build Body...");
		}

		public Car compose() {
			Car newCar = new Car(body, wheel);
			System.out.println("Success:"+count.addAndGet(1));
			return newCar;
		}

	}

	class Car {
		final String wheel;
		final String boby;

		public Car(String body, String wheel) {
			this.wheel = wheel;
			this.boby = body;
		}

	}

}
