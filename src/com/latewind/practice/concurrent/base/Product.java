package com.latewind.practice.concurrent.base;

public class Product {
	private String name;
	private Integer num;
	public Product(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getName();
	}

}
