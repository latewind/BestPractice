package com.latewind.pattern.behavioral.chain;

public class BaseLogger {
    public static final int INFO = 1;
    public static final int DEBUG = 2;
    public static final int ERROR = 3;
    protected int levle;
    protected BaseLogger nextLogger;

    public void log(int level, String message) {
        if (level <= this.levle) {
            System.out.println(this.getClass().getSimpleName() + ":" + message);
        } else {
            nextLogger.log(level, message);
        }
    }


}
