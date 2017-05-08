package com.latewind.practice.concurrent.syn;

public class VolatileTest {
	
	public static void main(String[] args) throws InterruptedException {
		
		VolatileValue value=new VolatileValue();
		new Thread(value).start();
		new Thread(value).start();
		new Thread(value).start();
		Thread.sleep(3000);
		value.change();
	}
	

}

class VolatileValue implements Runnable{
//	 boolean change=false;
	volatile boolean change=false;
	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+change);
		}
		
	}
	
	public void change(){
		change=true;
		System.err.println(Thread.currentThread().getName()+"change");
	}
	
	
}
