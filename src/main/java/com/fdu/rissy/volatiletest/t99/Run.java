package com.fdu.rissy.volatiletest.t99;

public class Run {

    public static void main(String[] args) {
//        PrintString printStringService = new PrintString();
//        new Thread(printStringService).start();
//        System.out.println("stopThread=" + Thread.currentThread().getName());
//        printStringService.setContinuePrint(false);
        try {
            RunThread thread = new RunThread();
            thread.start();
            Thread.sleep(1000);
            thread.setRunning(false);
            System.out.println("set to false");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
