package com.fdu.rissy.synchronizetest.test_2_2_11;

public class Run {

    public static void main(String[] args) {
        Service service = new Service();
        ThreadA athread = new ThreadA(service);
        athread.start();
        ThreadB bthread = new ThreadB(service);
        bthread.start();
    }
}
