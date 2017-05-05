package com.latewind.practice.concurrent.base;

import java.util.LinkedList;
import java.util.List;

public class ProductQueue {
	private List<Product> products = new LinkedList<Product>();

	public synchronized void put(Product product) {
		System.out.println(product.getName());
		products.add(product);
		notify();
	}

	public synchronized Product get() {
		try {
			while (products.isEmpty()) {
				wait();
				break;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return products.remove(products.size() - 1);

	}

}
