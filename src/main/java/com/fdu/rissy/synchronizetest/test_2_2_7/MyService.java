package com.fdu.rissy.synchronizetest.test_2_2_7;

public class MyService {

    public MyOneList addServiceMethod(MyOneList list, String data) {
        try {
            //need to add lock, otherwise there could be list.getSize() == 2 (dirty read): list.getSize(), list.add(data)
            synchronized (list) {
                if (list.getSize() < 1) {
                    Thread.sleep(2000);
                    list.add(data);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return list;
    }
}
