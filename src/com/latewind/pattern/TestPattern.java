package com.latewind.pattern;

public class TestPattern {

	public static void main(String[] args) {
		Jeep jeep=new Jeep();
		jeep.accept(new ExpDriver());
		
		jeep.accept(new NoviceDriver());
	}

}
