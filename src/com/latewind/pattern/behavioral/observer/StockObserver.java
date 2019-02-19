package com.latewind.pattern.behavioral.observer;

public class StockObserver extends Observer {

    public StockObserver(Reminder reminder) {
        super(reminder);

    }

    @Override
    public void update() {

        System.out.println("receive notice " + reminder.getAction());

    }

}
