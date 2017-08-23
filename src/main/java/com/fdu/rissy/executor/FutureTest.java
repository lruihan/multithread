package com.fdu.rissy.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureTest {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        List<Future<Integer>> futureList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            futureList.add(executorService.submit(new Task(i)));
        }
        for (int i = 0; i < 5; i++) {
            try {
                System.out.println(futureList.get(i).get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
