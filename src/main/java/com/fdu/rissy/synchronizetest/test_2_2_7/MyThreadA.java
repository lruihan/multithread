package com.fdu.rissy.synchronizetest.test_2_2_7;

public class MyThreadA extends Thread {

    private MyList list;

    public MyThreadA(MyList list) {
        this.list = list;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            list.add("threadA" + (i + 1));
        }
    }
}
