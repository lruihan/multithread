package com.fdu.rissy.threadlocaltest;

public class Run {

    public static ThreadLocal t1 = new ThreadLocal();

    public static ThreadLocalExt t2 = new ThreadLocalExt();

    public static void main(String[] args) {
//        if (t1.get() == null) {
//            System.out.println("never have value");
//            t1.set("my value");
//        }
//        System.out.println(t1.get());
//        System.out.println(t1.get());
//        try {
//            ThreadA a = new ThreadA();
//            ThreadB b = new ThreadB();
//            a.start();
//            b.start();
//            for (int i = 0; i < 100; i++) {
//                Tools.t1.set("Main" + (i + 1));
//                System.out.println("Main get Value=" + Tools.t1.get());
//                Thread.sleep(200);
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        try {
//            ThreadA a = new ThreadA();
//            a.start();
//            Thread.sleep(1000);
//            ThreadB b = new ThreadB();
//            b.start();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        if (t2.get() == null) {
//            System.out.println("never have value");
//            t1.set("my value");
//        }
//        System.out.println(t2.get());
//        System.out.println(t2.get());

        try {
            for (int i = 0; i < 10; i++) {
                System.out.println(" Main value = " + Tools.t1.get());
                Thread.sleep(100);
            }
            Thread.sleep(5000);
            ThreadA a = new ThreadA();
            a.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
