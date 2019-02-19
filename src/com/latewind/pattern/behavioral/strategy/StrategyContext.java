package com.latewind.pattern.behavioral.strategy;

/**
 * 策略模式：
 * 它定义了算法家族，分别封装起来，让它们之间可以互相替换
 * 此模式让算法的变化，不会影响到使用算法的客户
 */

public class StrategyContext {
    private Operation operation;

    public StrategyContext(Operation operation) {
        this.operation = operation;
    }

    public static void main(String[] args) {

        System.out.println("================Strategy Pattern=====================");
        StrategyContext sc = new StrategyContext(new AddOperation());
        System.out.println(sc.executeStrategy(1, 2));
        sc.setOperation(new MinusOperation());
        System.out.println(sc.executeStrategy(1, 2));
    }

    public double executeStrategy(double numA, double numB) {
        operation.setValue(numA, numB);
        return operation.gerResult();

    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

}
