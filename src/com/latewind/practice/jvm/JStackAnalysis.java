package com.latewind.practice.jvm;

import java.util.Date;

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
