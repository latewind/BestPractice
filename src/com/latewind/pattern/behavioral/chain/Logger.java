package com.latewind.pattern.behavioral.chain;

public class Logger {

    private static BaseLogger baseLogger = new InfoLogger(BaseLogger.INFO,
            new DebugLogger(BaseLogger.DEBUG, new ErrorLogger(BaseLogger.ERROR, null)));

    public static BaseLogger getLogger() {

        return baseLogger;
    }
}
