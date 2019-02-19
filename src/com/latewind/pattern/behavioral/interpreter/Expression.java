package com.latewind.pattern.behavioral.interpreter;

import java.util.HashMap;

public interface Expression {

    int interpret(HashMap<String, Number> variables);

}
