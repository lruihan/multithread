package com.fdu.rissy.synchronizetest.test_2_2_7;

import java.util.ArrayList;
import java.util.List;

public class MyList {

    private List list = new ArrayList();

    public synchronized void add(String username) {
        System.out.println("ThreadName=" + Thread.currentThread().getName() + " execute add method");
        list.add(username);
        System.out.println("ThreadName=" + Thread.currentThread().getName() + " exit add method");
    }
    public synchronized int getSize() {
        System.out.println("ThreadName=" + Thread.currentThread().getName() + " execute getSize method");
        int sizeValue = list.size();
        System.out.println("ThreadName=" + Thread.currentThread().getName() + " exit getSize method");
        return sizeValue;
    }
}
