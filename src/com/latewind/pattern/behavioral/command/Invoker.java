package com.latewind.pattern.behavioral.command;

import java.util.HashSet;
import java.util.Set;

public class Invoker {
    private Set<Commend> commends = new HashSet<>();

    public void executeCmd(Commend commend) {
        commends.add(commend);
        commend.execute();
    }

}
