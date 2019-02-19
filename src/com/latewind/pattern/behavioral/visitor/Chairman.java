package com.latewind.pattern.behavioral.visitor;

public class Chairman implements Person {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void answer() {

        System.out.println("I'm an Chairm man");

    }

}
