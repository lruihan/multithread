package com.fdu.rissy.synchronizetest.test_2_2_7;

public class Service {

    private String usernameParam;
    private String passwordParam;

    public void setUsernamePassword(String username, String password) {
        try {
            String anyString = new String();
            synchronized (anyString) {
                System.out.println(Thread.currentThread().getName() + " " + System.currentTimeMillis() + " enter sync");
                usernameParam = username;
                Thread.sleep(3000);
                passwordParam = password;
                System.out.println(Thread.currentThread().getName() + " " + System.currentTimeMillis() + " exit sync");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
