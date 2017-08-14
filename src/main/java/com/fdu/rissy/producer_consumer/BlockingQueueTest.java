package main.java.com.fdu.rissy.producer_consumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by lins13 on 4/20/17.
 */
public class BlockingQueueTest {

    public static void main(String[] args) {
        BlockingQueue<Integer> blockingQueue = new LinkedBlockingDeque<>();
        new Thread(new Producer(blockingQueue, 5)).start();
        new Thread(new Consumer(blockingQueue)).start();
    }
}

class Producer implements Runnable {

    private BlockingQueue<Integer> blockingQueue;
    private int size;

    private static int counter = 0;

    public Producer(BlockingQueue<Integer> blockingQueue, int size) {
        this.blockingQueue = blockingQueue;
        this.size = size;
    }

    @Override
    public void run() {
        while (true) {
            while (blockingQueue.size() < size) {
                blockingQueue.add(counter);
                System.out.println("Thread " + Thread.currentThread().getId() + " produced " + counter);
                counter++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class Consumer implements Runnable {

    private BlockingQueue<Integer> blockingQueue;

    public Consumer(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while (true) {
            //   synchronized (blockingQueue) {
            while (!blockingQueue.isEmpty()) {
                System.out.println("Thread " + Thread.currentThread().getId() + " consumed " + blockingQueue.remove());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //    }
        }
    }
}
