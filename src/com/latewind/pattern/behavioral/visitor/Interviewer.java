package com.latewind.pattern.behavioral.visitor;

public class Interviewer implements Visitor {

    @Override
    public void visit(Chairman chairman) {
        System.out.println("This is the :" + chairman.getClass().getSimpleName());

        chairman.answer();
    }

    @Override
    public void visit(Citizen citizen) {
        System.out.println("This is the :" + citizen.getClass().getSimpleName());
        citizen.answer();
    }


}
