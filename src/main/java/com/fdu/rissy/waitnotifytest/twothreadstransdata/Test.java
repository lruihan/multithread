package com.fdu.rissy.waitnotifytest.twothreadstransdata;

public class Test {

    public static void main(String[] args) {
        MyList list = new MyList();
        ThreadA a = new ThreadA(list);
        a.setName("A");
        a.start();
        ThreadB b = new ThreadB(list);
        b.setName("B");
        b.start();
    }
}
