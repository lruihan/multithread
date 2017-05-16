package com.fdu.rissy.mapCompare;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HashMapSimulator {

    private static final int THREADS_NUM = 3;
    private static final int TEST_ITERATIONS = 50;
    private static final int CAPACITY = 1000000;
    private static Map<String, Integer> assignedMapForTest = null;
    private static Map<String, Integer> nonThreadSafeMap = null;
    private static Map<String, Integer> threadSafeMap1 = null;
    private static Map<String, Integer> threadSafeMap2 = null;
    private static Map<String, Integer> threadSafeMap3 = null;

    public static void main(String[] args) {
        System.out.println("Compare different HashMap");

        for(int i = 0; i < TEST_ITERATIONS; i++) {
            //Not Thread Safe
            nonThreadSafeMap = new HashMap<>(CAPACITY);
            //Thread Safe, synchronize whole collection
            threadSafeMap1 = new Hashtable<>(CAPACITY);

            //Thread Safe, synchronize whole collection, synchronized container
            threadSafeMap2 = new HashMap<>(CAPACITY);
            threadSafeMap2 = Collections.synchronizedMap(threadSafeMap2);

            //Thread Safe, synchronizd on hashbucket
            threadSafeMap3 = new ConcurrentHashMap<>(CAPACITY);

            assignedMapForTest = nonThreadSafeMap;

            long timeBefore = System.currentTimeMillis();
            long timeAfter = 0;
            float totalProcessingTime;

            ExecutorService executor = Executors.newFixedThreadPool(THREADS_NUM);
            for(int j = 0; j < THREADS_NUM; j++) {
                Runnable worker = new WorkerThread(assignedMapForTest);
                executor.execute(worker);
            }
            executor.shutdown();
            while (!executor.isTerminated()) {

            }
            timeAfter = System.currentTimeMillis();
            totalProcessingTime = (timeAfter - timeBefore) / (float) 1000;
            System.out.println("All threads completed in " + totalProcessingTime + " seconds");
        }
    }
}
