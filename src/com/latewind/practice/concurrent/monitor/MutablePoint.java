package com.latewind.practice.concurrent.monitor;

public class MutablePoint {
	private final int x,y;
	public MutablePoint(int x,int y) {
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
