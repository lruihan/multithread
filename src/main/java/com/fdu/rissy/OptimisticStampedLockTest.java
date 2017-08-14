package main.java.com.fdu.rissy;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.StampedLock;

/**
 * Created by lruihan on 4/19/17.
 */
public class OptimisticStampedLockTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        StampedLock lock = new StampedLock();

        executorService.submit(() -> {
            //Optimistic lock doesn't prevent other threads to obtain a write lock
            long stamp = lock.tryOptimisticRead();
            try {
                System.out.println("Optimistic Lock Valid: " + lock.validate(stamp));
                ConcurrentUtils.sleep(1);
                System.out.println("Optimistic Lock Valid: " + lock.validate(stamp));
                ConcurrentUtils.sleep(2);
                System.out.println("Optimistic Lock Valid: " + lock.validate(stamp));
            } finally {
                lock.unlock(stamp);
            }
        });

        executorService.submit(() -> {
           long stamp = lock.writeLock();
           try {
               System.out.println("Write Lock acquired");
               ConcurrentUtils.sleep(2);
           } finally {
               lock.unlock(stamp);
               System.out.println("Write done");
           }
        });
        ConcurrentUtils.stop(executorService);
    }
}
