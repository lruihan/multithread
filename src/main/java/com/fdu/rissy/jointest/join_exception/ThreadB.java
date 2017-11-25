package com.fdu.rissy.jointest.join_exception;

public class ThreadB extends Thread {

    @Override
    public void run() {
        try {
            ThreadA a = new ThreadA();
            a.start();
            a.join();
            System.out.println("B printed at run end");
        } catch (InterruptedException e) {
            System.out.println("B printed in catch");
            e.printStackTrace();
        }
    }
}
