package com.fdu.rissy.waitnotifytest.stack_1;

import java.util.ArrayList;
import java.util.List;

public class MyStack {

    private List list = new ArrayList();

    public synchronized void push() {
        try {
            while (list.size() == 1) {
                this.wait();
            }
            list.add("anyString=" + Math.random());
            this.notifyAll();
            System.out.println("push=" + list.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized String pop() {
        String returnValue = "";
        try {
            while (list.size() == 0) {
                System.out.println("Pop: " + Thread.currentThread().getName() + " wait state");
                this.wait();
            }
            returnValue = "" + list.get(0);
            list.remove(0);
            this.notifyAll();
            System.out.println("pop=" + list.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return returnValue;
    }
}
