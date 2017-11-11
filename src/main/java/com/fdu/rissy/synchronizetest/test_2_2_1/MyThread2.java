package com.fdu.rissy.synchronizetest.test_2_2_1;

public class MyThread2 extends Thread {

    private Task task;
    public MyThread2(Task task) {
        super();
        this.task = task;
    }
    @Override
    public void run() {
        CommonUtils.beginTime2 = System.currentTimeMillis();
        task.doLongTimeTask2();
        CommonUtils.endTime2 = System.currentTimeMillis();
    }
}
