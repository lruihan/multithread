package com.fdu.rissy.synchronizetest.test_2_1_5;

public class PublicVar {

    public String username = "A";
    public String password = "AA";

    public synchronized void setValue(String username, String password) {
        try {
            this.username = username;
            Thread.sleep(5000);
            this.password = password;
            System.out.println("setValue method thred name=" + Thread.currentThread().getName() + " username=" +
                                username + " password=" + password);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public synchronized void getValue() {
        System.out.println("getValue method thread name=" + Thread.currentThread().getName()
                            + " username=" + username + " password=" + password);
    }
}
