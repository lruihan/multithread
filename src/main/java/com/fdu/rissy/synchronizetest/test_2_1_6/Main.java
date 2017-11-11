package com.fdu.rissy.synchronizetest.test_2_1_6;

public class Main {

    public int i = 10;
    public synchronized void operateInMainMethod() {
        try {
            i--;
            System.out.println("main print i=" + i);
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
