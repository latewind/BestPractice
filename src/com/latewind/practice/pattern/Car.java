package com.latewind.practice.pattern;

public abstract class Car {

	public void accept(Person person){
		person.visit(this);
	}
	public void gogogo(){
		System.out.println("上路");
	}
	
	public void refuse(){
		System.out.println("不能上路");
	}
	
	
}
