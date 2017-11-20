package com.fdu.rissy.waitnotifytest.waitOld;

public class ThreadAdd extends Thread {

    private Add add;

    public ThreadAdd(Add add) {
        this.add = add;
    }

    @Override
    public void run() {
        add.add();
    }
}
