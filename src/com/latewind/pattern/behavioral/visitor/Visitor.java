package com.latewind.pattern.behavioral.visitor;


public interface Visitor {
    void visit(Chairman chairman);

    void visit(Citizen citizen);

}
