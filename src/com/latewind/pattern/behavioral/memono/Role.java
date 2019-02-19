package com.latewind.pattern.behavioral.memono;

public class Role {
    private Integer vit;

    public Memento saveStatus() {

        return new Memento(this.vit);
    }

    public void resumeStatus(Memento memento) {

        vit = memento.getState();

    }

    public void setVit(Integer vInteger) {

        this.vit = vInteger;
    }

    @Override
    public String toString() {
        return "Role [vit=" + vit + "]";
    }

    public static class Memento {
        private Integer state;

        public Memento(Integer s) {
            state = s;
        }

        public Integer getState() {

            return state;
        }


    }


}
