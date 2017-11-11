package com.fdu.rissy.synchronizetest.test_2_2_1;

public class MyThread1 extends Thread {

    private Task task;
    public MyThread1(Task task) {
        super();
        this.task = task;
    }
    @Override
    public void run() {
        CommonUtils.beginTime1 = System.currentTimeMillis();
        task.doLongTimeTask2();
        CommonUtils.endTime1 = System.currentTimeMillis();
    }
}
