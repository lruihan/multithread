package com.fdu.rissy;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.IntStream;

/**
 * Created by lruihan on 4/19/17.
 */

/**
 * i++ is not atomic. volatile can not guarantee atomic, only visibility
 * 1)Use synchronized/lock - Reentrant WriteLock
 * 2)Use AtomicInteger
 */
public class CounterTest {

    private static AtomicInteger count = new AtomicInteger(0);
    //private static int count = 0;
    //private static ReadWriteLock lock = new ReentrantReadWriteLock();
    public static void increment() {
          count.incrementAndGet();
//        lock.writeLock().lock();
//        try {
//            count++;
//        }finally {
//            lock.writeLock().unlock();
//        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        IntStream.range(0, 10000).forEach(i -> executorService.submit(CounterTest::increment));

        ConcurrentUtils.stop(executorService);
        System.out.println(count);
    }
}
