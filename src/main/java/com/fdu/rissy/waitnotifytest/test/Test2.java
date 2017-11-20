package com.fdu.rissy.waitnotifytest.test;

public class Test2 {

    //wait() must be in synchronized block(obtained lock)
    public static void main(String[] args) {
        try {
            String lock = new String();
            System.out.println("above sync");
            synchronized (lock) {
                System.out.println("sync first");
                lock.wait();
                System.out.println("below wait");
            }

            System.out.println("below sync");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
