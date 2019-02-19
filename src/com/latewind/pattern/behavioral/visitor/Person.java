package com.latewind.pattern.behavioral.visitor;

public interface Person {
    void accept(Visitor visitor);

    void answer();

}
