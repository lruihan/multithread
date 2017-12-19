package com.fdu.rissy.locktest.reentrantLockTest.testLockMethods3;

public class Run2 {

    public static void main(String[] args) throws InterruptedException {
        MyService myService = new MyService();
        MyThreadA myThreadA = new MyThreadA(myService);
        myThreadA.start();
        Thread.sleep(2000);
        MyThreadB myThreadB = new MyThreadB(myService);
        myThreadB.start();
    }
}
