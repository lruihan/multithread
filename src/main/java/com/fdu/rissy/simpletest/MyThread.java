package com.fdu.rissy.simpletest;

/**
 * @author lins13
 * @date 11/7/17 11:01 AM
 **/
public class MyThread extends Thread {

//    private int i;
//    public MyThread(int i) {
//        super();
//        this.i = i;
//    }
//    @Override
//    public void run() {
////        try {
////            for (int i = 0; i < 10; i++) {
////                int time = (int) (Math.random() * 1000);
////                Thread.sleep(time);
////                System.out.println("run=" + Thread.currentThread().getName());
////            }
////        } catch (InterruptedException e) {
////            e.printStackTrace();
////        }
//        System.out.println(i);
//    }

//    private int count = 5;
//    @Override
//    public void run() {
//        super.run();
//        //count--;
//        System.out.println("count=" + (count--) + " run by " + Thread.currentThread().getName());
//    }

    public MyThread() {
        System.out.println("constructor method: " + Thread.currentThread().getName());
    }

    //use exception to interrupt thread

//    @Override
//    public void run() {
//        //System.out.println("run method: " + Thread.currentThread().getName());
//        super.run();
//        try {
//            int i = 0;
//            for (; i < 500000; i++) {
//                if (this.interrupted()) {
//                    System.out.println("Stop state now, exit");
//                    throw new InterruptedException();
//                }
//                System.out.println("i=" + (i + 1));
//            }
//            System.out.println("output again, thread is not stopped!");
//        } catch (InterruptedException e) {
//            System.out.println("catch exception");
//            e.printStackTrace();
//        }
//    }

//    private int i = 0;
//    @Override
//    public void run() {
//        try {
////            while (true) {
////                i++;
////                System.out.println("i=" + i);
////                Thread.sleep(1000);
////            }
//            this.stop();
//        } catch (ThreadDeath e) {
//            e.printStackTrace();
//        }
//    }

    private long i = 0;
    public long getI() {
        return i;
    }
    public void setI(long i) {
        this.i = i;
    }
    @Override
    public void run() {
        try {
            while (true) {
                i++;
                System.out.println(i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
//    @Override
//    public void run() {
//        long beginTime = System.currentTimeMillis();
//        int count = 0;
//        for (int i = 0; i < 50000000; i++) {
//            Thread.yield();
//            count = count + (i + 1);
//        }
//        long endTime = System.currentTimeMillis();
//        System.out.println("cost " + (endTime - beginTime) + " ms!");
//    }
}
