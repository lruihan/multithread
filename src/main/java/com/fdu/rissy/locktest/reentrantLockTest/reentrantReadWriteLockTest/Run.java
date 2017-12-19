package com.fdu.rissy.locktest.reentrantLockTest.reentrantReadWriteLockTest;

public class Run {

    public static void main(String[] args) throws InterruptedException {
        Service service = new Service();
        MyThreadB myThreadB = new MyThreadB(service);
        myThreadB.setName("B");
        myThreadB.start();
        Thread.sleep(1000);
        MyThreadA myThreadA = new MyThreadA(service);
        myThreadA.setName("A");
        myThreadA.start();
    }
}
