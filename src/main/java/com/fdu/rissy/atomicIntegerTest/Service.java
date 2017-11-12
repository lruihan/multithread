package com.fdu.rissy.atomicIntegerTest;

public class Service {

    private volatile boolean isContinueRun = true;
    String anyString = new String();
    public void runMethod() {
        while (isContinueRun) {

//            synchronized (anyString) {
//
//            }
        }
        System.out.println("Stopped! ");
    }
    public void stopMethod() {
        //synchronized (anyString) {
            isContinueRun = false;
        //}
    }
}
