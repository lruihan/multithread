package com.fdu.rissy.synchronizetest.test_2_2_1;

public class Task {

    private String getData1;
    private String getData2;

    public void doLongTimeTask() {
        try {
            System.out.println("begin task");
            Thread.sleep(3000);
            synchronized (this) {
                getData1 = "return from 1 threadName=" + Thread.currentThread().getName();
                getData2 = "return from 2 threadName=" + Thread.currentThread().getName();
            }
            System.out.println(getData1);
            System.out.println(getData2);
            System.out.println("end task");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void doLongTimeTask2() {
        for (int i = 0; i < 100; i++) {
            System.out.println("nosynchronized threadName=" + Thread.currentThread().getName()
                                + " i=" + (i + 1));
        }
        System.out.println("");
        synchronized (this) {
            for (int i = 0; i < 100; i++) {
                System.out.println("synchronized threadName=" + Thread.currentThread().getName()
                                    + " i=" + (i + 1));
            }
        }
    }
}
