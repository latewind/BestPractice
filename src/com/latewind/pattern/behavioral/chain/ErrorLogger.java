package com.latewind.pattern.behavioral.chain;

public class ErrorLogger extends BaseLogger {

    public ErrorLogger(int level, BaseLogger nextLogger) {
        this.levle = level;
        this.nextLogger = nextLogger;
    }
}
