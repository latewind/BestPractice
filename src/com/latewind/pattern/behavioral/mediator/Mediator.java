package com.latewind.pattern.behavioral.mediator;

import java.util.LinkedList;
import java.util.List;

public abstract class Mediator {
    protected List<Member> members = new LinkedList<>();

    public abstract void viewMsg(String message);

    public void add(Member member) {
        members.add(member);
    }
}
