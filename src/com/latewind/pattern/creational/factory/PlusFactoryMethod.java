package com.latewind.pattern.creational.factory;

public class PlusFactoryMethod implements FactoryMethod {

    @Override
    public Operation getOperation() {
        //  Auto-generated method stub
        return new PlusOperation();
    }

}
