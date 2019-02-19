package com.latewind.pattern.creational.builder;

public class Computer {
    private String screen;

    private String mothorBoard;

    private String keyBoard;

    private String cpu;

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public String getMothorBoard() {
        return mothorBoard;
    }

    public void setMothorBoard(String mothorBoard) {
        this.mothorBoard = mothorBoard;
    }

    public String getKeyBoard() {
        return keyBoard;
    }

    public void setKeyBoard(String keyBoard) {
        this.keyBoard = keyBoard;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    @Override
    public String toString() {
        return "Computer [screen=" + screen + ", mothorBoard=" + mothorBoard + ", keyBoard=" + keyBoard + ", cpu=" + cpu
                + "]";
    }


}
