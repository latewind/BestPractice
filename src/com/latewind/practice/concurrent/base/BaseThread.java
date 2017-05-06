package com.latewind.practice.concurrent.base;

import java.util.Random;

public abstract class BaseThread implements Runnable {
	public int INTERVAL_TIME=3000;
	protected volatile boolean canRun=true;
	protected Random random =new Random();
	

	protected ProductQueue queue;

	public BaseThread(ProductQueue queue) {
		this.queue=queue;
	}
	public void stop(){
		canRun=false;
	}
}
