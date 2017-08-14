package main.java.com.fdu.rissy;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.StampedLock;

/**
 * Created by lruihan on 4/19/17.
 */
public class StampedLockTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Map<String, String> map = new HashMap<>();
        //StampedLock is not Reentrant, may cause DeadLock
        StampedLock lock = new StampedLock();
        executorService.submit(() -> {
           long stamp = lock.writeLock();
           try {
               ConcurrentUtils.sleep(1);
               map.put("foo", "bar");
           } finally {
               lock.unlockWrite(stamp);
           }
        });

        Runnable readTask = () -> {
            long stamp = lock.readLock();
            try {
                System.out.println(map.get("foo"));
                ConcurrentUtils.sleep(1);
            } finally {
                lock.unlockRead(stamp);
            }
        };

        executorService.submit(readTask);
        executorService.submit(readTask);

        ConcurrentUtils.stop(executorService);
    }
}
