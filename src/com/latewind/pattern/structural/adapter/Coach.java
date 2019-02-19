package com.latewind.pattern.structural.adapter;

public class Coach {
    private Player player;

    public Coach(Player player) {

        this.player = player;
    }

    public void attackAction() {
        player.attrack();

    }

    public void setPlayer(Player player) {

        this.player = player;

    }

}
