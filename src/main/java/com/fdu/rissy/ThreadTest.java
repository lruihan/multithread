package main.java.com.fdu.rissy;

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
public class ThreadTest {
    private static final int startIndex = 0;
    private static final int endIndex = 100;
    public static void main(String[] args) {
        MyThread t1 = new MyThread(startIndex, 1, endIndex);
        MyThread t2 = new MyThread(startIndex, 2, endIndex);
        MyThread t3 = new MyThread(startIndex, 3, endIndex);
        t1.start();
        t2.start();
        t3.start();
    }
}
class MyThread extends Thread {

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
        lock.lock();
        try {
            for (int i = startIndex; i < endIndex; i += nThread) {
                System.out.println("[Thread " + this.getId() + "]" + i);
                //Thread.yield();
            }
        }finally {
            lock.unlock();
        }
    }
}
