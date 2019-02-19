package com.latewind.pattern.creational.builder;

public abstract class ComputerBuilder {

    protected Computer computer;

    public ComputerBuilder() {
        computer = new Computer();
    }

    public abstract void buildScreen();

    public abstract void buildMotherBoard();

    public abstract void buildKeyBoard();

    public abstract void buildCpu();

    public Computer getComputer() {

        return computer;
    }

}
