package com.fdu.rissy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class SumOfFactorial {

    int[][] a = new int[2][4];

    {
        a[0] = new int[3];
    }

    public SumOfFactorial() {

    }

    public static void main(String[] args) {
//        Test test = new Test();
//        List<Integer> input = Arrays.asList(10, 10, 10);
//        //using CountDownlatch & Runnable
//        long res = test.getResult(input);
//        //using CountDownlatch & Runnable & ExecutorService
//        long resExecutorService = test.getResultExecutorService(input);
//        //using CountDown latch & callable & ExecutorService
//        long resExecutorServiceCallable = test.getResultExecutorServiceCallable(input);
//        //using callable & ExcecutorService & CompletionService
//        long resCompletionService = test.getResultCompletionService(input);
//        System.out.println("final result is " + res + ", " + resExecutorService + ", " + resExecutorServiceCallable + ", " + resCompletionService);
    }

    public long getResult(List<Integer> input) {
        final CountDownLatch countDownLatch = new CountDownLatch(input.size());
        List<Calculator> calculators = new ArrayList<>();
        int i = 1;
        for (int val : input) {
            Calculator calculator = new Calculator(i++, val, countDownLatch);
            calculators.add(calculator);
        }
        for (Calculator calculator : calculators) {
            new Thread(calculator).start();
        }
        try {
            countDownLatch.await();
            System.out.println("All calculations are done.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long sum = 0;
        for (Calculator calculator : calculators) {
            sum += calculator.getResult();
        }
        return sum;
    }

    public long getResultExecutorService(List<Integer> input) {
        final CountDownLatch countDownLatch = new CountDownLatch(input.size());
        List<Calculator> calculators = new ArrayList<>();
        int i = 1;
        for (int val : input) {
            Calculator calculator = new Calculator(i++, val, countDownLatch);
            calculators.add(calculator);
        }
        ExecutorService executorService = Executors.newFixedThreadPool(input.size());
        for (Calculator calculator : calculators) {
            executorService.submit(calculator);
        }
        try {
            countDownLatch.await();
            System.out.println("All calculations are done.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long sum = 0;
        for (Calculator calculator : calculators) {
            sum += calculator.getResult();
        }
        shutDownExecutorService(executorService);
        return sum;
    }

    public long getResultExecutorServiceCallable(List<Integer> input) {
        final CountDownLatch countDownLatch = new CountDownLatch(input.size());
        List<AnotherCalculator> calculators = new ArrayList<>();
        int i = 1;
        for (int val : input) {
            AnotherCalculator calculator = new AnotherCalculator(i++, val, countDownLatch);
            calculators.add(calculator);
        }
        ExecutorService executorService = Executors.newFixedThreadPool(input.size());
        List<Future<Long>> futures = new ArrayList<>();
        for (AnotherCalculator calculator : calculators) {
            futures.add(executorService.submit(calculator));
        }
        try {
            countDownLatch.await();
            System.out.println("All calculations are done.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long sum = 0;
        try {
            for (Future<Long> future : futures) {
                sum += future.get();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        shutDownExecutorService(executorService);
        return sum;
    }

    public long getResultCompletionService(List<Integer> input) {
        int size = input.size();
        List<AnotherCalculator2> calculators = new ArrayList<>();
        int id = 1;
        for (int val : input) {
            AnotherCalculator2 calculator = new AnotherCalculator2(id++, val);
            calculators.add(calculator);
        }
        ExecutorService executorService = Executors.newFixedThreadPool(size);
        ExecutorCompletionService<Long> completionService = new ExecutorCompletionService<>(executorService);

        for (AnotherCalculator2 calculator : calculators) {
            completionService.submit(calculator);
        }
        long sum = 0;
        try {
            for (int i = 0; i < size; i++) {
                Future<Long> future = completionService.take();
                sum += future.get();
            }
            System.out.println("All calculations are done.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        shutDownExecutorService(executorService);
        return sum;
    }

    private void shutDownExecutorService(ExecutorService executorService) {
        executorService.shutdown();
        try {
            if (executorService.awaitTermination(5, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Calculator implements Runnable {

    private final int id;
    private final int value;
    private final CountDownLatch latch;
    private long result = 1;

    public Calculator(int id, int value, CountDownLatch latch) {
        this.id = id;
        this.value = value;
        this.latch = latch;
    }

    @Override
    public void run() {
        for (int i = 1; i <= value; i++) {
            result *= i;
        }
        System.out.println(id + "th's thread result is: " + result);
        latch.countDown();
    }

    public long getResult() {
        return result;
    }
}

class AnotherCalculator implements Callable<Long> {

    private final int id;
    private final int value;
    private final CountDownLatch latch;

    public AnotherCalculator(int id, int value, CountDownLatch latch) {
        this.id = id;
        this.value = value;
        this.latch = latch;
    }

    @Override
    public Long call() {
        long result = 1;
        for (int i = 1; i <= value; i++) {
            result *= i;
        }
        System.out.println(id + "th's thread result is: " + result);
        latch.countDown();
        return result;
    }
}

class AnotherCalculator2 implements Callable<Long> {

    private final int id;
    private final int value;

    public AnotherCalculator2(int id, int value) {
        this.id = id;
        this.value = value;
    }

    @Override
    public Long call() {
        long result = 1;
        for (int i = 1; i <= value; i++) {
            result *= i;
        }
        System.out.println(id + "th's thread result is: " + result);
        return result;
    }
}
