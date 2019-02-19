package com.latewind.pattern.behavioral.interpreter;

import java.util.HashMap;

public class Number implements Expression {
    Integer number;

    public Number(Integer number) {
        this.number = number;
    }

    @Override
    public int interpret(HashMap<String, Number> variables) {
        return this.number;
    }

}
