package com.latewind.pattern.behavioral.command;

public class RunCommend implements Commend {
    private Receiver receiver;

    public RunCommend(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.executeRunning();


    }

}
