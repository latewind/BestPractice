package com.latewind.pattern.behavioral.chain;

public class DebugLogger extends BaseLogger {
    public DebugLogger(int level, BaseLogger nextLogger) {
        this.levle = level;
        this.nextLogger = nextLogger;
    }
}
