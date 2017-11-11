package com.fdu.rissy.synchronizetest.test_2_1_8;

public class Test {

    //synchronization couldn't be inherited, the sub method should also be synchronized.ggggg
    public static void main(String[] args) {
        Sub subRef = new Sub();
        MyThreadA a = new MyThreadA(subRef);
        a.setName("A");
        a.start();
        MyThreadB b = new MyThreadB(subRef);
        b.setName("B");
        b.start();
    }
}
