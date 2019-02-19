package com.latewind.pattern.structural.adapter;

public class Translater implements Player {

    private ForeignPlayer player;

    public Translater(ForeignPlayer player) {

        this.player = player;
    }

    @Override
    public void attrack() {

        player.hi_attack();


    }

    @Override
    public void defence() {

        player.hi_defence();
    }

}
