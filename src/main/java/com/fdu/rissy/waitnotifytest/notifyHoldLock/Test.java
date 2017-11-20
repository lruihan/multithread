package com.fdu.rissy.waitnotifytest.notifyHoldLock;

public class Test {

    //wait() will release lock, but not notify(), it will release until it executes the synchronized block
    public static void main(String[] args) {
        Object lock = new Object();
        ThreadA a = new ThreadA(lock);
        a.start();
        NotifyThread notifyThread = new NotifyThread(lock);
        notifyThread.start();
        SynNotifyMethodThread synNotifyMethodThread = new SynNotifyMethodThread(lock);
        synNotifyMethodThread.start();
    }
}
