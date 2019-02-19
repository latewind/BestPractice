package com.latewind.pattern.creational.builder;

public class Director {
    private ComputerBuilder builder;

    public Director(ComputerBuilder builder) {
        this.builder = builder;
    }

    public void constructComputer() {

        builder.buildMotherBoard();
        builder.buildCpu();
        builder.buildScreen();
        builder.buildKeyBoard();

    }

    public Computer getComputer() {

        return builder.getComputer();
    }


}
