package com.fdu.rissy.jointest.join_sleep_1;

public class ThreadA extends Thread {

    private ThreadB b;
    public ThreadA(ThreadB b) {
        this.b = b;
    }

    @Override
    public void run() {
        try {
            synchronized (b) {
                b.start();
                //sleep will not release lock
                //Thread.sleep(6000);
                //join will release lock
                b.join();
                for (int i = 0; i < Integer.MAX_VALUE; i++) {
                    String newString = new String();
                    Math.random();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
