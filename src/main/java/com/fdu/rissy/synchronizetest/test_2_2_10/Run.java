package com.fdu.rissy.synchronizetest.test_2_2_10;

public class Run {

    //if using string as lock, it stands for one same lock. since a = "ff", b = "ff", a == b
    public static void main(String[] args) {
        Service service = new Service();
        ThreadA a = new ThreadA(service);
        a.setName("A");
        a.start();
        ThreadB b = new ThreadB(service);
        b.setName("B");
        b.start();
    }
}
