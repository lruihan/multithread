package main.java.com.fdu.rissy.threadpool;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

/**
 * Created by lruihan on 4/22/17.
 */
public class ForkJoinPoolTest {

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        CountTask task = new CountTask(1, 500000);
        long start = System.currentTimeMillis();
        Future<Integer> result = forkJoinPool.submit(task);

        try {
            System.out.println(result.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis() - start);
    }
}
