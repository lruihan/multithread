package com.fdu.rissy.deadlock;

public class FixDeadLock {
    private static Object lock1 = new Object();
    private static Object lock2 = new Object();

    public static void main(String[] args) {
        new FixDeadLock.Thread1().start();
        new FixDeadLock.Thread2().start();
    }

    static class Thread1 extends Thread {
        public void run() {
            synchronized (lock1) {
                System.out.println("Thread1: Holding Lock1");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {

                }
                System.out.println("Thread1: Waiting Lock2");
                synchronized (lock2) {
                    System.out.println("Thread1: Holding Lock1 & Lock2");
                }
            }
        }
    }

    static class Thread2 extends Thread {
        public void run() {
            synchronized (lock1) {
                System.out.println("Thread2: Holding Lock1");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {

                }
                System.out.println("Thread2: Waiting Lock2");
                synchronized (lock2) {
                    System.out.println("Thread2: Holding Lock1 & Lock2");
                }
            }
        }
    }
}
