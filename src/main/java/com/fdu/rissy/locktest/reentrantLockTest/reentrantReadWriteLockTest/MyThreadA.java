package com.fdu.rissy.locktest.reentrantLockTest.reentrantReadWriteLockTest;

import com.fdu.rissy.locktest.reentrantLockTest.testLockMethods3.MyService;

public class MyThreadA extends Thread {

    private Service myService;

    public MyThreadA(Service myService) {
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.read();
    }
}
