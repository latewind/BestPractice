package com.latewind.practice.concurrent.base;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;


public class ProductQueue {
	private List<Product> products = new LinkedList<Product>();
	static final Integer MAX_SIZE=50;
	public synchronized void put(Product product) {
		if(isNotFull()){
			System.out.println(product.getName());
			products.add(product);
		}
		notifyAll();
	}

	public synchronized Product get() {
		try {
			while (products.isEmpty()) { 
				wait();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return products.remove(products.size() - 1);

	}
	public int getSize(){
		
		return products.size();
	}
	
	private  boolean isNotFull(){
		
		return !Objects.equals(MAX_SIZE, products.size());
	}

}
