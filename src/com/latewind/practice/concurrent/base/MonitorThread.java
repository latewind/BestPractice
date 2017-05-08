package com.latewind.practice.concurrent.base;

import java.awt.List;
import java.util.Arrays;
import java.util.LinkedList;

public class MonitorThread extends BaseThread {
	private LinkedList<Consumer> consumersQueue = new LinkedList<Consumer>();
	private LinkedList<Producer> producerQueue = new LinkedList<Producer>();
	private static MonitorThread monitorThread;
	private MonitorThread(ProductQueue queue) {
		super(queue);
	}
	public static MonitorThread getInstance(ProductQueue queue){
		if(monitorThread==null){
			synchronized(MonitorThread.class){
				if(monitorThread==null){
					monitorThread=new MonitorThread(queue);
				}
			}
		}
		return monitorThread;
			
	}
	 
	public void init() {
		for (int i = 0; i < 3; i++) {
			Consumer consumer = new Consumer(queue);
			Producer producer = new Producer(queue);
			consumersQueue.add(consumer);
			producerQueue.add(producer);
			new Thread(consumer).start();
			new Thread(producer).start();
		}
	}

	@Override
	public void run() {

		while (true) {
			try {
				Thread.sleep(3000);
				if (queue.getSize() > 25) {
					consumersQueue.add(new Consumer(queue));
					new Thread(consumersQueue.getLast()).start();
				} else {
					if (!consumersQueue.isEmpty()) {
						consumersQueue.removeLast().stop();
					}
				}

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(queue.getSize());
		}

	}

}
