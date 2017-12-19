package com.fdu.rissy.locktest.reentrantLockTest.reentrantReadWriteLockTest;

import com.fdu.rissy.locktest.reentrantLockTest.testLockMethods3.MyService;

public class MyThreadB extends Thread {

    private Service myService;

    public MyThreadB(Service myService) {
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.write();
    }
}
