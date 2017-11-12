package com.fdu.rissy.atomicIntegerTest;

import java.util.concurrent.atomic.AtomicLong;

public class MyService {

    public static AtomicLong aiRef = new AtomicLong();

    public synchronized void addNum() {
        System.out.println(Thread.currentThread().getName() + " after adding 100 :"
                + aiRef.addAndGet(100));
        aiRef.addAndGet(1);
    }
}
