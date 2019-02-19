package com.latewind.pattern.structural.decorator;

public class DoorDecorator extends StructDecorator {

    public void decorator(House decorator) {
        this.house = decorator;
    }

    @Override
    public void display() {
        System.out.println("door");
        house.display();
    }

}
