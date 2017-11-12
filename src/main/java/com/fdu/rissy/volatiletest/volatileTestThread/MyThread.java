package com.fdu.rissy.volatiletest.volatileTestThread;

public class MyThread extends Thread {

    public static int count;
    private synchronized static void addCount() {
        for (int i = 0; i < 100; i++) {
            count++;
        }
        System.out.println("count=" + count);
    }
    @Override
    public void run() {
        addCount();
    }
}
