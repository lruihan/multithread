package com.fdu.rissy.waitnotifytest.notifyHoldLock;

public class ThreadA extends Thread {

    private Object lock;
    public ThreadA(Object lock) {
        this.lock = lock;
    }
    @Override
    public void run() {
        Service service = new Service();
        service.testMethod(lock);
    }
}
