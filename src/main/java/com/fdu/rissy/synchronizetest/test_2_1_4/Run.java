package com.fdu.rissy.synchronizetest.test_2_1_4;

public class Run {

    //if methodB is not synchronized, there will be no fixed order. They will share the same lock.
    public static void main(String[] args) {
        MyObject object = new MyObject();
        ThreadA a = new ThreadA(object);
        a.setName("A");
        ThreadB b = new ThreadB(object);
        b.setName("B");
        a.start();
        b.start();
    }
}
