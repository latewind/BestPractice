package com.latewind.practice.concurrent.delegate;

public class InmutablePoint {

	private final int x,y;
	public InmutablePoint(int x,int y) {
		this.x=x;
		this.y=y;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
}
