package com.fdu.rissy.synchronizetest.test_2_2_7;

public class MyThreadB extends Thread {

    private MyList list;

    public MyThreadB(MyList list) {
        this.list = list;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            list.add("threadB" + (i + 1));
        }
    }
}
