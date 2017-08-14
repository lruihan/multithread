package com.fdu.rissy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest {

    private static Logger logger = LoggerFactory.getLogger(ConditionTest.class);

    private ReentrantLock restartLock = new ReentrantLock();
    private ReentrantLock waitForResult = new ReentrantLock();
    private Condition resultCondition = waitForResult.newCondition();

    private volatile boolean restartResult;
    public static void main(String[] args) {

        ConditionTest test = new ConditionTest();

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; i++) {
            executorService.submit(() -> test.restart());
        }
        //  test.restart();
        try {
            executorService.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            logger.error("interrupted...", e);
        } finally {
            executorService.shutdown();
        }
    }
    public boolean restart() {
        if (restartLock.tryLock()) {
            return performRestart();
        } else {
            return waitAndGetResult();
        }
    }

    private boolean waitAndGetResult() {
        logger.info("waiting for result...");
        waitForResult.lock();
        try {
            resultCondition.await();
            logger.info("signaled... " + restartResult);
            return restartResult;
        } catch (InterruptedException e) {
            logger.error("interrupted when waiting for result");
        } finally {
            waitForResult.unlock();
        }
        return restartResult;
    }

    private boolean performRestart() {
        logger.info("Performing restart");
        try {
            Thread.sleep(3000);
            logger.info("restart finished");
        } catch (InterruptedException e) {
            logger.error("interrupted when restarting");
        } finally {
            restartLock.unlock();
            waitForResult.lock();
            try {
                resultCondition.signalAll();
            } finally {
                waitForResult.unlock();
            }
        }
        restartResult = true;
        return restartResult;
    }
}
