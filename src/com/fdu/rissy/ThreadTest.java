package com.fdu.rissy;

/**
 * Created by lruihan on 4/18/17.
 */
public class ThreadTest {
    private static final int startIndex = 0;
    private static final int endIndex = 100;
    public static void main(String[] args) {
        MyThread t1 = new MyThread(startIndex, 1, endIndex);
        MyThread t2 = new MyThread(startIndex, 2, endIndex);
        MyThread t3 = new MyThread(startIndex, 3, endIndex);
        t1.start();
        t2.start();
        t3.start();
    }
}
