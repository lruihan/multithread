package com.fdu.rissy.synchronizetest.test_2_1_6;

public class Run {

    //synchronized is reentrant, otherwise there will be deadlock. Also sub will inherit the same lock.
    public static void main(String[] args) {
        MyThread2 t = new MyThread2();
        t.start();
    }
}
