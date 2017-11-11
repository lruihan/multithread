package com.fdu.rissy.synchronizetest.test_2_2_11;

public class ThreadB extends Thread {

    private Service service;

    public ThreadB(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.methodB();
    }
}
