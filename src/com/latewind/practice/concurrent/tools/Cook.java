package com.latewind.practice.concurrent.tools;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class Cook {
	Kettle kettle=new Kettle();
	public static void main(String[] args) {
		new Cook().cook();
	}

	void cook(){
		new Thread(kettle).start();
		try {
			System.out.println("waiting for the hotwater..");
			HotWarter warter=kettle.get();
			System.out.println("hotwater is ready:"+warter.temperature);
			System.out.println("cook food");
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}
	
}

class Kettle extends FutureTask<HotWarter> {

	public Kettle() {
		super(new Callable<HotWarter>() {

			@Override
			public HotWarter call() throws Exception {
				HotWarter hotWarter = new HotWarter();
				Thread.sleep(2000);
				hotWarter.temperature = 50;
				System.out.println("the temperature is :" + hotWarter.temperature);
				hotWarter.temperature = 100;
				Thread.sleep(3000);
				System.out.println("the temperature is :" + hotWarter.temperature);
				return hotWarter;
			}

		});
	}

}

class HotWarter {
	int temperature = 0;

}