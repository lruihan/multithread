package com.fdu.rissy.waitnotifytest.wait_timeout;

public class MyRunnable {

    private static Object lock = new Object();
    private static Runnable runnable1 = () -> {
        try {
            synchronized (lock) {
                System.out.println("wait begin time=" + System.currentTimeMillis());
                lock.wait(5000);
                System.out.println("wait end time=" + System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    };

    private static Runnable runnable2 = () -> {
        synchronized (lock) {
            System.out.println("notify begin time=" + System.currentTimeMillis());
            lock.notify();
            System.out.println("notify end time=" + System.currentTimeMillis());
        }
    };

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(runnable1);
        t1.start();
        Thread.sleep(3000);
        Thread t2 = new Thread(runnable2);
        t2.start();
    }
}