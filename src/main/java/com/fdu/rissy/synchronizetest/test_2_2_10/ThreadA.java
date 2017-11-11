package com.fdu.rissy.synchronizetest.test_2_2_10;

public class ThreadA extends Thread {

    private Service service;

    public ThreadA(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.print(new Object());
    }
}
