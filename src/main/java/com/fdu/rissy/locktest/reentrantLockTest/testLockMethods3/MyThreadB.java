package com.fdu.rissy.locktest.reentrantLockTest.testLockMethods3;

public class MyThreadB extends Thread {

    private MyService myService;

    public MyThreadB(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.notifyMethod();
    }
}
