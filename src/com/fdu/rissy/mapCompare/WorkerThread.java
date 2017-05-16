package com.fdu.rissy.mapCompare;

import java.util.Map;

public class WorkerThread implements Runnable {

    private Map<String, Integer> map = null;

    public WorkerThread(Map<String, Integer> assignedMap) {
        this.map = assignedMap;
    }

    @Override
    public void run() {
        for(int i = 0; i < 500000; i++) {
            Integer newInteger1 = (int) Math.ceil(Math.random() * 1000000);
            Integer newInteger2 = (int) Math.ceil(Math.random() * 1000000);

            Integer retrievedInteger = map.get(String.valueOf(newInteger1));

            map.put(String.valueOf(newInteger2), newInteger2);
        }
    }
}
