package com.latewind.pattern.behavioral.mediator;

public abstract class Member {
    protected Mediator mediator;
    protected String name;

    private Member() {

    }

    public Member(Mediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
        mediator.add(this);
    }

    public abstract void send(String message);

    public void getMsg(String msg) {

        System.out.println(name + "receive" + msg);
    }
}
