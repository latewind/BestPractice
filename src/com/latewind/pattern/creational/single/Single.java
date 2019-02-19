package com.latewind.pattern.creational.single;

public class Single {

    private static Single single = new Single();

    private Single() {

    }

    public static Single getInstance() {
        return single;
    }

    public void show() {

        System.out.println("This is a Single Instance");
    }
}
