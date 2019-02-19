package com.latewind.pattern.behavioral.state;

public class Morning implements TimeStatus {

    @Override
    public void done(EveryDay everyDay) {
        //  Auto-generated method stub
        int hour = everyDay.getTime().getHour();
        if (hour > 10) {

            everyDay.setTimeStatus(new Noon());
            everyDay.done();
        } else {

            System.out.println("morning");
        }

    }

}
