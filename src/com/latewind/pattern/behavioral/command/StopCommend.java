package com.latewind.pattern.behavioral.command;

public class StopCommend implements Commend {
    private Receiver receiver;

    public StopCommend(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.executeStop();


    }

}
