package com.latewind.pattern.behavioral.chain;


public class InfoLogger extends BaseLogger {

    public InfoLogger(int level, BaseLogger nextLogger) {
        this.levle = level;
        this.nextLogger = nextLogger;
    }
}
