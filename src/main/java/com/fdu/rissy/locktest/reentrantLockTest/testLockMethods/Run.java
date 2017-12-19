package com.fdu.rissy.locktest.reentrantLockTest.testLockMethods;

public class Run {

    public static void main(String[] args) throws InterruptedException {
        final Service service = new Service();
        //service.serviceMethod1();
        Runnable runnable = () -> {
            service.waitMethod();
        };
        Thread[] threadArray = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threadArray[i] = new Thread(runnable);
        }
        for (int i = 0; i < 10; i++) {
            threadArray[i].start();
        }
        Thread.sleep(2000);
        service.notifyMethod();
    }
}
