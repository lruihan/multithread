package com.fdu.rissy.synchronizetest.test_2_2_7;

public class MyThread2 extends Thread {

    private MyOneList list;

    public MyThread2(MyOneList list) {
        this.list = list;
    }

    @Override
    public void run() {
        MyService msRef = new MyService();
        msRef.addServiceMethod(list, "B");
    }
}
