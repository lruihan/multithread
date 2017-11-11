package com.fdu.rissy.synchronizetest.test_2_1_6;

public class Sub extends Main {

    public synchronized void operateInSubMethod() {
        try {
            while (i > 0) {
                i--;
                System.out.println("sub print i=" + i);
                Thread.sleep(100);
                this.operateInMainMethod();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
