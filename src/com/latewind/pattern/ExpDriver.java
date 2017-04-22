package com.latewind.pattern;

public class ExpDriver implements Person{

	@Override
	public void visit(Car car) {
		System.out.println("ÀÏË¾»ú");
		car.gogogo();
	}
	
}
