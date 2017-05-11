package com.latewind.practice.concurrent;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class Container {
	ConcurrentHashMap<String, Integer> concurrentHashMap;
	CopyOnWriteArrayList<Integer> copyOnWriteArrayList;

}
