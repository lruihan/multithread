package com.fdu.rissy.synchronizetest.test_2_1_8;

public class Main {

    public synchronized void serviceMethod() {
        try {
            System.out.println("int main next sleep begin threadName="
                                + Thread.currentThread().getName() + " time="
                                + System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("int main next sleep end threadName="
                                + Thread.currentThread().getName() + " time= "
                                + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
