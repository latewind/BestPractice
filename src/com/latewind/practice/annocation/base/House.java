package com.latewind.practice.annocation.base;

import java.lang.annotation.Annotation;

public class House {
	@Person(name="Tom")
	private String person;
	
	private String window;
	
	private String door;
	
	public void configHouse(){
		
		Class<House> clazz=House.class;
		Annotation [] as= clazz.getAnnotations();
		for(Annotation a:as){
			a.annotationType().equals(Person.class);
		}
		 
		
	}
	
}
