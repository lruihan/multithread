package com.fdu.rissy.synchronizetest.test_2_2_7;

import java.util.ArrayList;
import java.util.List;

public class MyOneList {

    private List list = new ArrayList();

    public synchronized void add(String data) {
        list.add(data);
    }

    public synchronized int getSize() {
        return list.size();
    }
}
