package com.fdu.rissy.atomicIntegerTest;

public class ThreadA extends Thread {

    private Service service;
    public ThreadA(Service service) {
        this.service = service;
    }
    @Override
    public void run() {
        service.runMethod();
    }
}