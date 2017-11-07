package com.fdu.rissy.memoizer;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by lruihan on 4/29/17.
 */
public class MemoizerTest {

    public static void main(String[] args) {
        final Random random = new Random();

        Computable<Integer, Integer> computable = new Computable<Integer, Integer>() {
            @Override
            public Integer compute(Integer arg) throws InterruptedException {
                System.out.println("The argument is " + arg);
                if(arg > 7) {
                    throw new IllegalStateException();
                }
                Thread.sleep(arg * 1000 * 5);
                return arg;
            }
        };

        final Memoizer<Integer, Integer> memoizer1 = new Memoizer<>(computable);

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 100; i++) {
            executorService.submit(new Callable<Object>() {
                @Override
                public Object call() throws Exception {
                    System.out.println("The compute result is " + memoizer1.compute(random.nextInt(10)));
                    return null;
                }
            });
        }
        executorService.shutdown();
    }

}
