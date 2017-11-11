package com.fdu.rissy.synchronizetest.test_2_1_6;

public class MyThread extends Thread {

    @Override
    public void run() {
        Service service = new Service();
        service.service1();
    }
}
