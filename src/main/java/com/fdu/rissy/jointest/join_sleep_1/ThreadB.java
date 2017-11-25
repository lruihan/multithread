package com.fdu.rissy.jointest.join_sleep_1;

public class ThreadB extends Thread {

    @Override
    public void run() {
        try {
            System.out.println(" b run begin time=" + System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println(" b run end time=" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void bService() {
        System.out.println("print bService timer=" + System.currentTimeMillis());
    }
}
