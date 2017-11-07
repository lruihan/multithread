package com.fdu.rissy.threadpool;

/**
 * Created by lruihan on 4/22/17.
 */
public class Task implements Runnable{

    private int num;

    public Task(int n) {
        this.num = n;
    }

    public void run() {
        System.out.println("Task " + num + " is running.");
    }

}
