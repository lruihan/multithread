package com.fdu.rissy.locktest.reentrantLockTest.reentrantLock2;

public class Run {

    public static void main(String[] args) {
        MyService service = new MyService();
        ThreadA threadA = new ThreadA(service);
        threadA.setName("A");
        threadA.start();
        ThreadAA threadAA = new ThreadAA(service);
        threadAA.setName("AA");
        threadAA.start();
        ThreadB threadB = new ThreadB(service);
        threadB.setName("B");
        threadB.start();
        ThreadBB threadBB = new ThreadBB(service);
        threadBB.setName("BB");
        threadBB.start();

    }
}
