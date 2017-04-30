package com.latewind.practice.jvm;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class JStackAnalysis {
	
	
	public static void main(String[] args) {
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				while (true) {
					
					System.out.println("Runnable.."+new Date());
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
					}
				}
				
				
			}
		}).start();
			
	}

}
