package com.latewind.pattern.structural.facade;

public class Facade {

    private Astock astock;

    private Hstock hstock;

    public Facade(Astock astock, Hstock hstock) {

        this.astock = astock;
        this.hstock = hstock;

    }

    public void in() {
        astock.buy();
        hstock.buy();
    }

    public void out() {

        astock.sell();
        hstock.sell();

    }
}
