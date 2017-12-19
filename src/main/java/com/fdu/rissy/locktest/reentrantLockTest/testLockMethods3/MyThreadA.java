package com.fdu.rissy.locktest.reentrantLockTest.testLockMethods3;

public class MyThreadA extends Thread {

    private MyService myService;

    public MyThreadA(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.waitMethod();
    }
}
