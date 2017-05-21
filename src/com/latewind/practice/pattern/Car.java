package com.latewind.practice.pattern;

public abstract class Car {

	public void accept(Person person){
		person.visit(this);
	}
	public void gogogo(){
		System.out.println("??·");
	}
	
	public void refuse(){
		System.out.println("??????·");
	}
	
	
}
