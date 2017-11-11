package com.fdu.rissy.synchronizetest.test_2_1_1;

public class Run {

    //if var is in method(stack), there will be no thread-safe issue
    //if lock is same,it will be synchronized, otherwise async
    public static void main(String[] args) {
        HasSelfPrivateNum numRef = new HasSelfPrivateNum();
        HasSelfPrivateNum numRef2 = new HasSelfPrivateNum();
        ThreadA threadA = new ThreadA(numRef);
        threadA.start();
        ThreadB threadB = new ThreadB(numRef2);
        threadB.start();
    }
}
