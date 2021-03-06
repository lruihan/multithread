package com.fdu.rissy.locktest.reentrantLockTest.multipleCondition;

public class Run {

    public static void main(String[] args) throws InterruptedException {
        MyService myService = new MyService();
        ThreadA threadA = new ThreadA(myService);
        threadA.setName("A");
        threadA.start();
        ThreadB threadB = new ThreadB(myService);
        threadB.setName("B");
        threadB.start();
        Thread.sleep(3000);
        myService.signalAll_A();
    }
}
