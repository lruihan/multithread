package com.fdu.rissy.synchronizetest.test_2_1_6;

public class MyThread2  extends Thread {

    @Override
    public void run() {
        Sub sub = new Sub();
        sub.operateInSubMethod();
    }
}