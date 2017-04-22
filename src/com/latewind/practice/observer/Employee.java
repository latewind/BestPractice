package com.latewind.practice.observer;

import java.util.Observable;
import java.util.Observer;

public class Employee implements Observer {
	private String name ;
	
	public Employee(String name) {
		this.name=name;
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		System.out.println(this.name+"I have received don't notice me");
		arg0.deleteObserver(this);	
	}
	
	public static void main(String[] args) {
		Assistent assistent=new Assistent();
		Employee employee1=new Employee("Lee");
		Employee employee2=new Employee("Ching");
		
		assistent.addObserver(employee1);
		assistent.addObserver(employee2);
		assistent.setChanged();
		assistent.notifyObservers();
		
		assistent.notifyObservers();
	}
}
