package com.latewind.practice.pattern;

public class NoviceDriver implements Person {
	@Override
	public void visit(Car car) {
		System.out.println("��˾��");
		car.refuse();
	}
}
