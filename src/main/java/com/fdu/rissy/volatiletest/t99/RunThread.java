package com.fdu.rissy.volatiletest.t99;

public class RunThread extends Thread {

    //use volatile to read from main memory, and write to main memory
    private volatile boolean isRunning = true;

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    @Override
    public void run() {
        System.out.println("enter run method");
        while (isRunning) {

        }
        System.out.println("thread is stopped");
    }
}
