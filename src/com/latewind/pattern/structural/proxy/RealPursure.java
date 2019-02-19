package com.latewind.pattern.structural.proxy;

public class RealPursure implements Pursure {
    private String mmName;

    public RealPursure(String mmName) {
        this.mmName = mmName;

    }

    @Override
    public void giveFlower() {

        System.out.println(" This flower give" + mmName);


    }

    @Override
    public void giveMoney() {

        System.out.println("This money give" + mmName);
    }

}
