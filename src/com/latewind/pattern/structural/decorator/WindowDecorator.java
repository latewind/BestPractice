package com.latewind.pattern.structural.decorator;

public class WindowDecorator extends StructDecorator {
    @Override
    public void display() {
        System.out.println("window");
        house.display();
    }

}
