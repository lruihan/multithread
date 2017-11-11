package com.fdu.rissy.synchronizetest.test_2_1_8;

public class Sub extends Main {

    @Override
    public synchronized void serviceMethod() {
        try {
            System.out.println("int sub next sleep begin threadName="
                    + Thread.currentThread().getName() + " time="
                    + System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("int sub next sleep end threadName="
                    + Thread.currentThread().getName() + " time= "
                    + System.currentTimeMillis());
            super.serviceMethod();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
