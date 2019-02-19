package com.latewind.pattern.behavioral.mediator;

public class ChatRoom extends Mediator {

    @Override
    public void viewMsg(String message) {
        //  Auto-generated method stub
        for (Member member : members) {
            member.getMsg(message);
        }
    }

}
