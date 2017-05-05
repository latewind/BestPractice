package com.latewind.practice.concurrent.base;

import java.util.Random;

public abstract class BaseThread implements Runnable {
	protected Random random =new Random();

	protected ProductQueue queue;

	public BaseThread(ProductQueue queue) {
		this.queue=queue;
	}
}
