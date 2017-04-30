package com.latewind.practice.arrayclone;

import java.util.ArrayList;

public class ArrayCloneTest {

	public static void main(String[] args) {
		// TODO Auto-generatDDed method stub
new ArrayCloneTest().test();
		

	}
	public void test(){
		ArrayList<Point> list1=new ArrayList<Point>();
		ArrayList<Point> list2=new ArrayList<Point>();
		Point point1=new Point(1, 1);
		list1.add(point1);
		list2.addAll(list1);
		point1.setX(100);
		System.out.println(list2);
		
		
	}
	
	
	class Point{
		int x;
		int y;
		public Point(int x,int y) {
			this.x=x;
			this.y=y;
		}
		public void setX(int x){
			
			this.x=x;
		}
		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}
		
		
	}
	
}
