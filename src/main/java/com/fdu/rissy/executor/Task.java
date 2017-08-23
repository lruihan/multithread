package com.fdu.rissy.executor;

import java.util.concurrent.Callable;

public class Task implements Callable<Integer> {
    private final int param;

    public Task(int param) {
        this.param = param;
    }
    @Override
    public Integer call() throws Exception {
        Thread.sleep((10 - param) * 1000);
        return param;
    }
}
