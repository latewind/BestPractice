package com.latewind.pattern.creational.factory;

public class SimpleFactory {

    public static Operation getOperation(String operation) {

        switch (operation) {
            case "+":
                return new PlusOperation();
            case "-":
                return new MinusOperation();

        }
        return null;
    }


}
