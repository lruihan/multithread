package com.fdu.rissy.locktest.reentrantLockTest.testLockMethods3;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {

    public ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void waitMethod() {
//        try {
//            lock.lockInterruptibly();
//            System.out.println("lock begin " + Thread.currentThread().getName());
//            for (int i = 0; i < Integer.MAX_VALUE / 10; i++) {
//                String newString = new String();
//                Math.random();
//            }
//            System.out.println("lock end " + Thread.currentThread().getName());
//        } catch (InterruptedException e) {
//            System.out.println("catch " + Thread.currentThread().getName());
//            e.printStackTrace();
//        } finally {
//            if (lock.isHeldByCurrentThread()) {
//                lock.unlock();
//            }
//        }
//        if (lock.tryLock()) {
//            System.out.println(Thread.currentThread().getName() + " acquired lock!");
//        } else {
//            System.out.println(Thread.currentThread().getName() + " not acquire lock!");
//        }
//        try {
//            if (lock.tryLock(3, TimeUnit.SECONDS)) {
//                System.out.println(" " + Thread.currentThread().getName()
//                                    + " acquired lock time : " + System.currentTimeMillis());
//                Thread.sleep(10000);
//            } else {
//                System.out.println(" " + Thread.currentThread().getName()
//                        + " not acquire lock");
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } finally {
//            if (lock.isHeldByCurrentThread()) {
//                lock.unlock();
//            }
//        }

        try {
            Calendar calendarRef = Calendar.getInstance();
            calendarRef.add(Calendar.SECOND, 10);
            lock.lock();
            System.out.println("wait begin timer=" + System.currentTimeMillis());
            condition.awaitUntil(calendarRef.getTime());
            System.out.println("wait end timer=" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void notifyMethod() {
        try {
            Calendar calendarRef = Calendar.getInstance();
            calendarRef.add(Calendar.SECOND, 10);
            lock.lock();
            System.out.println("notify begin timer=" + System.currentTimeMillis());
            condition.signalAll();
            System.out.println("notify end timer=" + System.currentTimeMillis());
        } finally {
            lock.unlock();
        }
    }
    public void testMethod() {
        try {
            lock.lock();
            System.out.println("wait begin");
            condition.awaitUninterruptibly();
            System.out.println("wait end");
        } finally {
            lock.unlock();
        }
    }
}
