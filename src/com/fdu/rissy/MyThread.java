package com.fdu.rissy;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by lruihan on 4/18/17.
 */

/**
 * Using Thread.yield() couldn't guarantee executing sequentially
 * Guarantee sequential
 * 1)use synchronized on the Class Object, not instance Object
 * 2)use lock object
 */
public class MyThread extends Thread {

    private int startIndex;
    private int nThread;
    private int endIndex;

    private static final Lock lock = new ReentrantLock();

    public MyThread(int startIndex, int nThread, int endIndex) {
        this.startIndex = startIndex;
        this.nThread = nThread;
        this.endIndex = endIndex;
    }

    @Override
    public void run() {
        // synchronized (MyThread.class) {
        try {
            lock.lock();
            for (int i = startIndex; i < endIndex; i += nThread) {
                System.out.println("[Thread " + this.getId() + "]" + i);
                //Thread.yield();
            }
        }finally {
            lock.unlock();
        }
    }
}
