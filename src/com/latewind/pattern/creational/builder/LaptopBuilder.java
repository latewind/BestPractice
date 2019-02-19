package com.latewind.pattern.creational.builder;

public class LaptopBuilder extends ComputerBuilder {

    public LaptopBuilder() {

        super();
    }

    @Override
    public void buildScreen() {
        computer.setScreen("SAMSUNG");
    }

    @Override
    public void buildMotherBoard() {

        computer.setMothorBoard("SHENZHOU");
    }

    @Override
    public void buildKeyBoard() {
        computer.setKeyBoard("A4TECH");
    }

    @Override
    public void buildCpu() {
        computer.setCpu("i5-4210M");
    }

}
