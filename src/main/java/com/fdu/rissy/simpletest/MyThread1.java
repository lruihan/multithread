package com.fdu.rissy.simpletest;

import java.util.Random;

public class MyThread1 extends Thread {

//    @Override
//    public void run() {
////        System.out.println("MyThread1 run priority=" + this.getPriority());
////        MyThread2 thread2 = new MyThread2();
////        thread2.start();
//        long beginTime = System.currentTimeMillis();
//        long addResult = 0;
//        for (int j = 0; j < 10; j++) {
//            for (int i = 0; i < 50000; i++) {
//                Random random = new Random();
//                random.nextInt();
//                addResult += i;
//            }
//        }
//        long endTime = System.currentTimeMillis();
//        System.out.println("****** thread 1 use time=" + (endTime - beginTime));
//    }
    private long i = 0;
    public long getI() {
        return i;
    }
    public void setI(long i) {
        this.i = i;
    }
    @Override
    public void run() {
        while (true) {
            i++;
            //  System.out.println(i);
        }
    }
}
