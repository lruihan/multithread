package com.fdu.rissy.locktest.reentrantLockTest.reentrantLock2;

public class ThreadAA extends Thread {

    private MyService myService;

    public ThreadAA(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.methodA();
    }
}
