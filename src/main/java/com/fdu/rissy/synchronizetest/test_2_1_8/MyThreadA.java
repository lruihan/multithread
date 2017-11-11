package com.fdu.rissy.synchronizetest.test_2_1_8;

public class MyThreadA extends Thread {

    private Sub sub;

    public MyThreadA(Sub sub) {
        super();
        this.sub = sub;
    }

    @Override
    public void run() {
        sub.serviceMethod();
    }
}
