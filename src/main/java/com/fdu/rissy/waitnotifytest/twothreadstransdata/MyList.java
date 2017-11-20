package com.fdu.rissy.waitnotifytest.twothreadstransdata;

import java.util.ArrayList;
import java.util.List;

public class MyList {

    private List list = new ArrayList();

    public void add() {
        list.add("test");
    }

    public int size() {
        return list.size();
    }
}
