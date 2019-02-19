package com.latewind.pattern.creational.factory;

public abstract class Operation {
    protected double numA;
    protected double numB;

    public Operation setValue(double numA, double numB) {

        this.numA = numA;
        this.numB = numB;

        return this;
    }

    public abstract double gerResult();
}


class MinusOperation extends Operation {

    @Override
    public double gerResult() {
        //  Auto-generated method stub
        return numA - numB;
    }


}