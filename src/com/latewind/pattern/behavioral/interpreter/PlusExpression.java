package com.latewind.pattern.behavioral.interpreter;

import java.util.HashMap;

public class PlusExpression implements Expression {
    private Expression leftExp;
    private Expression rightExp;

    public PlusExpression(Expression leftExp, Expression rightExp) {
        this.leftExp = leftExp;
        this.rightExp = rightExp;
    }

    @Override
    public int interpret(HashMap<String, Number> variables) {

        return leftExp.interpret(variables) + rightExp.interpret(variables);
    }

}
