package com.latewind.pattern.structural.bridge;

public abstract class Phone {

    protected App app;

    public void install(App app) {

        this.app = app;
    }

    public abstract void runApp();


}
