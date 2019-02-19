package com.latewind.pattern.behavioral.interpreter;

import java.util.HashMap;

public class MinusExpression implements Expression {
    private Expression leftExp;
    private Expression rightExp;

    public MinusExpression(Expression leftExp, Expression rightExp) {
        this.leftExp = leftExp;
        this.rightExp = rightExp;
    }

    @Override
    public int interpret(HashMap<String, Number> variables) {

        return leftExp.interpret(variables) - rightExp.interpret(variables);
    }

}
