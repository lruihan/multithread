package com.fdu.rissy.locktest.reentrantLockTest.producerConsumerCondition;

public class Run {

    public static void main(String[] args) {
        MyService myService = new MyService();
//        ThreadA threadA = new ThreadA(myService);
//        threadA.start();
//        ThreadB threadB = new ThreadB(myService);
//        threadB.start();
        ThreadA[] threadAs = new ThreadA[10];
        ThreadB[] threadBs = new ThreadB[10];
        for (int i = 0; i < 10; i++) {
            threadAs[i] = new ThreadA(myService);
            threadBs[i] = new ThreadB(myService);
            threadAs[i].start();
            threadBs[i].start();
        }
    }
}
