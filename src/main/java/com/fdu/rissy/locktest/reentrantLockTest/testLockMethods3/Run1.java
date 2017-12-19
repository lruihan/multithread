package com.fdu.rissy.locktest.reentrantLockTest.testLockMethods3;

public class Run1 {

    public static void main(String[] args) {
        MyService myService = new MyService();
        MyThreadA myThreadA = new MyThreadA(myService);
        myThreadA.start();
    }
}
