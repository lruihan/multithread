package com.fdu.rissy.executor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CompletableFutureTest {

    public static void main(String[] args) {
        CompletableFutureTest completableFutureTest = new CompletableFutureTest();
        try {
            completableFutureTest.testAsyncMethod();
            //System.out.println(res.get());
            //res.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public Future<String> calculateAsync() throws InterruptedException {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        Executors.newCachedThreadPool().submit(() -> {
           Thread.sleep(500);
           completableFuture.complete("Hello");
           return null;
        });
        return completableFuture;
    }

    public Future<String> calculateAsyncWithCancellation() throws InterruptedException {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        Executors.newCachedThreadPool().submit(() -> {
            Thread.sleep(500);
            completableFuture.cancel(false);
            return null;
        });
        return completableFuture;
    }

    public Future<Void> combine() throws InterruptedException {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<Void> future = completableFuture.thenAccept(s -> System.out.println("result: " + s));
        return future;
    }

    public Future<Void> runParallel() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "Beautiful");
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> "World");

        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(future1, future2, future3);

      //  combinedFuture.get();

        System.out.println(future1.isDone());
        System.out.println(future2.isDone());
        System.out.println(future3.isDone());

        String combined = Stream.of(future1, future2, future3)
                .map(CompletableFuture::join)
                .collect(Collectors.joining(" "));
        System.out.println(combined);
        return combinedFuture;
    }

    public void handleError() throws ExecutionException, InterruptedException {
        String name = "Rissy";
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            if (name == null) {
                throw new RuntimeException("Computation error!");
            }
            return "Hello, " + name;
        }).handle((s, t) -> s != null ? s : "Hello, Stranger!");
        System.out.println(completableFuture.get());
    }

    public void completeWithException() throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        completableFuture.completeExceptionally(new RuntimeException("Calculation failed!"));
        completableFuture.get();
    }

    /**
     * XXAsync if no Executor passed in, use ForkJoinPool; otherwise use Executor passed in
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public void testAsyncMethod() throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> future = completableFuture.thenApplyAsync(s -> s + " World");
        System.out.println(future.get());
    }
}
