package com.fdu.rissy;

import java.util.Date;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest2 {

    public static void main(String[] args) {
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        Thread serviceOneThread = new Thread(new ServiceOne(cyclicBarrier));
        Thread serviceTwoThread = new Thread(new ServiceTwo(cyclicBarrier));
        System.out.println("Starting two services at " + new Date());
        serviceOneThread.start();
        serviceTwoThread.start();
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            System.out.println("Main thread is interrupted");
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            System.out.println("Main thread is interrupted");
            e.printStackTrace();
        }
        System.out.println("Ending two services at " + new Date());
    }
}

class ServiceOne implements Runnable {

    private final CyclicBarrier cyclicBarrier;

    public ServiceOne(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        System.out.println("Starting to run ServiceOne");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ServiceOne finished...");
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            System.out.println("ServiceOne is interrupted");
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            System.out.println("ServiceOne is interrupted");
            e.printStackTrace();
        }
        System.out.println("Waiting for ServiceTwo to finish");
    }
}

class ServiceTwo implements Runnable {

    private final CyclicBarrier cyclicBarrier;

    public ServiceTwo(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        System.out.println("Starting to run ServiceTwo");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ServiceTwo finished...");
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            System.out.println("ServiceTwo is interrupted");
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            System.out.println("ServiceTwo is interrupted");
            e.printStackTrace();
        }
        System.out.println("Waiting for ServiceOne to finish");
    }
}
