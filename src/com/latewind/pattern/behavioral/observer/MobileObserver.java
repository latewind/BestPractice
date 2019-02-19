package com.latewind.pattern.behavioral.observer;

public class MobileObserver extends Observer {

    public MobileObserver(Reminder reminder) {
        super(reminder);

    }

    @Override
    public void update() {

        System.out.println("receive notice " + this.getClass() + reminder.getAction());

    }

}
