package com.fdu.rissy.locktest.reentrantLockTest.testLockMethods3;

public class MyThread extends Thread {

    private MyService myService;

    public MyThread(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.testMethod();
    }
}
