package com.latewind.practice.inject;

public class InjectTarget {

	@Inject
	private String name;

	@Override
	public String toString() {
		return "InjectTarget [name=" + name + "]";
	}
	
}
