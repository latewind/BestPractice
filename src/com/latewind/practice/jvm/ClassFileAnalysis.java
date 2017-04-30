package com.latewind.practice.jvm;

import java.util.ArrayList;
import java.util.List;

public class ClassFileAnalysis {
	private static final String string = "I am a Class";

	public int i = 4;

	public Integer j=new Integer(5);
	public static void main(String[] args) {
		new ClassFileAnalysis().print();
	}
	
	public void print(){
		List<Object> list=new ArrayList<Object>();
		System.out.println(sum(i, j));
		
	}
	private int sum(int v1,int v2){
		
		return v1+v2;
	}
}
