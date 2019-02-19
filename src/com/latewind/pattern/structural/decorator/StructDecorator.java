package com.latewind.pattern.structural.decorator;

public abstract class StructDecorator implements House {
    protected House house;

    public void decorator(House decorator) {
        this.house = decorator;
    }

    @Override
    public void display() {
        house.display();
    }

    ;


}
