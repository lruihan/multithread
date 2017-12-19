package com.fdu.rissy.locktest.reentrantLockTest.testLockMethods3;

import java.util.concurrent.locks.ReentrantLock;

public class Service {

    private ReentrantLock lock;

    public Service(boolean isFair) {
        lock = new ReentrantLock(isFair);
    }

    public void serviceMethod() {
        try {
            //System.out.println(lock.isHeldByCurrentThread());
            System.out.println(lock.isLocked());
            lock.lock();
            System.out.println(lock.isLocked());
            //System.out.println(lock.isHeldByCurrentThread());
           // System.out.println("isFair? " + lock.isFair());
        } finally {
            lock.unlock();
        }
    }
}
