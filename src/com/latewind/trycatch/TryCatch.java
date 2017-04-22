package com.latewind.trycatch;

public class TryCatch {
	
	
	public static int compute(Integer num1,Integer num2){
		
		try{
			return num1/num2;
		}catch(Exception e){
			
		}
		return num1;
	}
	
	public static void main(String[] args){
		
		System.out.println(TryCatch.compute(2, 1));
	}
	

}
