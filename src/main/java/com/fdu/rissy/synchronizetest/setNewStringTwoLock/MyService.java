package com.fdu.rissy.synchronizetest.setNewStringTwoLock;

public class MyService {

    private String lock = "123";

    //lock changed, it will become async. it will be ok if only changing the attributes of object
    public void testMethod() {
        try {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + " begin "
                                    + System.currentTimeMillis());
                lock = "456";
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + " end "
                                    + System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
