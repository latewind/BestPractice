package com.latewind.pattern.creational.factory;

public class StrategyContext {
    private Operation operation;

    public StrategyContext(Operation operation) {
        this.operation = operation;
    }

    public double executeStrategy(double numA, double numB) {
        operation.setValue(numA, numB);
        return operation.gerResult();

    }

}
