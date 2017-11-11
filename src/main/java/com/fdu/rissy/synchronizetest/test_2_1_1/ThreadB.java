package com.fdu.rissy.synchronizetest.test_2_1_1;

public class ThreadB extends Thread {
    private HasSelfPrivateNum numRef;
    public ThreadB(HasSelfPrivateNum numRef) {
        super();
        this.numRef = numRef;
    }
    @Override
    public void run() {
        super.run();
        numRef.addI("b");
    }
}
