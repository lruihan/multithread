package com.fdu.rissy.threadtest;

public class SynchronizedObject {

    public synchronized void printString() {
        System.out.println("begin");
        if (Thread.currentThread().getName().equals("a")) {
            System.out.println("a suspend forever");
            Thread.currentThread().suspend();
        }
        System.out.println("end");
    }
}
