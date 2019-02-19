package com.latewind.practice.oo;

import java.lang.reflect.Field;

public abstract class GrandPa extends Human{
	private Integer step;
	
	@Override
	public void walk() {
		
		Field [] fields=this.getClass().getDeclaredFields();
		for(Field field:fields){
			System.out.println(field);
			field.setAccessible(true);
			try {
				field.set(this,"Tom");
			} catch (IllegalArgumentException | IllegalAccessException e) {
				//  Auto-generated catch block
				e.printStackTrace();
			}
		}
		//  Auto-generated method stub
	System.out.println(this.getClass()+"walk"+step);	
	
	}
	
	public void setStep(Integer step){
		this.step=step;
	}

}
