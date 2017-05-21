package com.latewind.practice.pattern;

public class ExpDriver implements Person{

	@Override
	public void visit(Car car) {
		System.out.println("?????");
		car.gogogo();
	}
	
}
