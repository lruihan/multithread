package com.fdu.rissy.threadlocaltest;

import java.util.Date;

public class ThreadA extends Thread {

    @Override
    public void run() {
        try {
//            for (int i = 0; i < 100; i++) {
//                Tools.t1.set("ThreadA" + (i + 1));
//                System.out.println("ThreadA get Value=" + Tools.t1.get());
//                Thread.sleep(200);
//            }
//            for (int i = 0; i < 20; i++) {
//                if (Tools.t1.get() == null) {
//                    Tools.t1.set(new Date());
//                }
//                System.out.println("A " + Tools.t1.get().getTime());
//                Thread.sleep(100);
//            }
            for (int i = 0; i < 10; i++) {
                System.out.println("in ThreadA value = " + Tools.t1.get());
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
