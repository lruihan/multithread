package main.java.com.fdu.rissy;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.StampedLock;

/**
 * Created by lruihan on 4/20/17.
 */
public class StampedConvertToWriteLockTest {

    private static int count = 0;
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        StampedLock lock = new StampedLock();
        executorService.submit(() -> {
           long stamp = lock.readLock();
           try {
               if (count == 0) {
                   //not blocking
                   stamp = lock.tryConvertToWriteLock(stamp);
                   if (stamp == 0L) {
                       System.out.println("Could not convert to write lock");
                       stamp = lock.writeLock();
                   }
                   count = 23;
               }
               System.out.println(count);
           } finally {
               lock.unlock(stamp);
           }
        });

        ConcurrentUtils.stop(executorService);
    }
}
