package com.latewind.practice.concurrent.immutable;

import java.util.HashSet;
/**
 * this is thread , when the class is created,the animals will not change 
 * 
 *
 */
public class AnimalList {
	private final HashSet<String> animals = new HashSet<>();

	public AnimalList() {
		animals.add("Cat");
		animals.add("Dog");
		animals.add("Sleep");
	}

	public boolean isContain(String name) {
		return animals.contains(name);
	}
}
