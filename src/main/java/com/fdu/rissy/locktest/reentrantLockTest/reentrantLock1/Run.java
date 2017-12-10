package com.fdu.rissy.locktest.reentrantLockTest.reentrantLock1;

public class Run {

    public static void main(String[] args) {

        MyService service = new MyService();
        MyThread thread1 = new MyThread(service);
        MyThread thread2 = new MyThread(service);
        MyThread thread3 = new MyThread(service);
        MyThread thread4 = new MyThread(service);
        MyThread thread5 = new MyThread(service);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }
}
