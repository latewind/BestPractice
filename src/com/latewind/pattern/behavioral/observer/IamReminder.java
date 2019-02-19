package com.latewind.pattern.behavioral.observer;

import java.util.LinkedList;
import java.util.List;

public class IamReminder implements Reminder {
    private List<Observer> observers = new LinkedList<>();
    private String action = "action!";

    @Override
    public void notice() {

        for (Observer observer : observers) {

            observer.update();
        }

        //  Auto-generated method stub

    }

    @Override
    public void attach(Observer observer) {

        observers.add(observer);
    }

    @Override
    public void remove() {


    }

    @Override
    public String getAction() {

        return this.action;
    }

}
