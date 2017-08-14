package com.fdu.rissy;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {

    static CyclicBarrier barrier;

    public static void main(String[] args) throws InterruptedException {
        barrier = new CyclicBarrier(3);
        new Worker().start();
        Thread.sleep(1000);
        new Worker().start();
        Thread.sleep(1000);
        new Worker().start();
        Thread.sleep(1000);

        System.out.println("Barrier automatically resets");
        new Worker().start();
        Thread.sleep(1000);
        new Worker().start();
        Thread.sleep(1000);
        new Worker().start();
    }
}

class Worker extends Thread {
    @Override
    public void run() {
        try {
            CyclicBarrierTest.barrier.await();
            System.out.println("Let's play.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
