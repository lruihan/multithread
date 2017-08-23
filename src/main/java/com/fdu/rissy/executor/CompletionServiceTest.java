package com.fdu.rissy.executor;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CompletionServiceTest {

    public static void main(String[] args) throws ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        CompletionService service = new ExecutorCompletionService(executorService);

        for (int i = 0; i < 5; i++) {
            service.submit(new Task(i));
        }
        try {
            for (int i = 0; i < 5; i++) {
                Future<Integer> future = service.take();
                System.out.println(future.get());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
