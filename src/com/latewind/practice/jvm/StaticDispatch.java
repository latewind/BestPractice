package com.latewind.practice.jvm;

import java.util.ArrayList;
import java.util.Date;

public class StaticDispatch {


	public void sayHello(Human guy) {
		System.out.println("hello,guy£¡");
	}

	public void sayHello(Man guy) {
		System.out.println("hello,gentleman£¡");
	}

	public void sayHello(Woman guy) {
		System.out.println("hello,lady£¡");
	}

	public static void main(String[] args) {
		Human man = new Man();
		Human woman = new Woman();
		StaticDispatch sr = new StaticDispatch();
		sr.sayHello(man);
		sr.sayHello(woman);
		
	}
}

  class Human {
}

 class Man extends Human {
}

 class Woman extends Human {
}