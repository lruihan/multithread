package com.fdu.rissy;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by lruihan on 4/19/17.
 */
public class ReentrantReadWriteLockTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Map<String, String> map = new HashMap<>();
        ReadWriteLock lock = new ReentrantReadWriteLock();

        executorService.submit(() -> {
            lock.writeLock().lock();
            try {
                ConcurrentUtils.sleep(1);
                map.put("foo", "bar");
                System.out.println("Already Put");
            } finally {
                lock.writeLock().unlock();
            }
        });

        Runnable readTask = () -> {
            lock.readLock().lock();
            try {
                System.out.println(map.get("foo"));
                ConcurrentUtils.sleep(1);
            } finally {
                lock.readLock().unlock();
            }
        };

        executorService.submit(readTask);
        executorService.submit(readTask);

        ConcurrentUtils.stop(executorService);
    }
}
