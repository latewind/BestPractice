package com.latewind.pattern;

public class NoviceDriver implements Person {
	@Override
	public void visit(Car car) {
		System.out.println("ÐÂË¾»ú");
		car.refuse();
	}
}
