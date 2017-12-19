package com.fdu.rissy.locktest.reentrantLockTest.testLockMethods;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Service {

    public ReentrantLock lock = new ReentrantLock();

    private Condition newCondition = lock.newCondition();

//    public void serviceMethod1() {
//        try {
//            lock.lock();
//            System.out.println("serviceMethod1 getHoldCount="
//                        + lock.getHoldCount());
//            serviceMethod2();
//        } finally {
//            lock.unlock();
//        }
//    }
//
//    public void serviceMethod2() {
//        try {
//            lock.lock();
//            System.out.println("serviceMethod2 getHoldCount="
//                    + lock.getHoldCount());
//        } finally {
//            lock.unlock();
//        }
//    }

    public void serviceMethod1() {
        try {
            lock.lock();
            System.out.println("ThreadName=" + Thread.currentThread().getName()
                                + " entered method!");
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void waitMethod() {
        try {
            lock.lock();
            newCondition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void notifyMethod() {
        try {
            lock.lock();
            System.out.println(lock.hasWaiters(newCondition) + ", " + lock.getWaitQueueLength(newCondition) + " threads are waiting for newCondition");
            newCondition.signal();
        } finally {
            lock.unlock();
        }
    }
}
