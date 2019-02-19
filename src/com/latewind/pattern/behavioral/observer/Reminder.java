package com.latewind.pattern.behavioral.observer;

public interface Reminder {


    void notice();

    void attach(Observer observer);

    void remove();

    String getAction();
}
