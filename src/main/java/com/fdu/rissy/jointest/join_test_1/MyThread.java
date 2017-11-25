package com.fdu.rissy.jointest.join_test_1;

public class MyThread extends Thread {

    @Override
    public void run() {
        try {
//            int secondValue = (int) (Math.random() * 10000);
//            System.out.println(secondValue);
//            Thread.sleep(secondValue);
            System.out.println("begin time=" + System.currentTimeMillis());
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
