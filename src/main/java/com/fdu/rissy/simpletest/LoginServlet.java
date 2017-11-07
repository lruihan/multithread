package com.fdu.rissy.simpletest;

/**
 * @author lins13
 * @date 11/7/17 11:44 AM
 **/
public class LoginServlet {
    private static String usernameRef;
    private static String passwordRef;

    public static synchronized void doPost(String username, String password) {
        try {
            usernameRef = username;
            if (username.equals("a")) {
                Thread.sleep(5000);
            }
            passwordRef = password;
            System.out.println("username=" + usernameRef + " password=" + passwordRef);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
