package com.fdu.rissy.synchronizetest.test_2_2_7;

public class Run {

    //different locks will execute async
    public static void main(String[] args) throws InterruptedException {
//        Service service = new Service();
//        ThreadA a = new ThreadA(service);
//        a.setName("A");
//        a.start();
//        ThreadB b = new ThreadB(service);
//        b.setName("B");
//        b.start();

        MyOneList list = new MyOneList();
        MyThread1 thread1 = new MyThread1(list);
        thread1.setName("A");
        thread1.start();
        MyThread2 thread2 = new MyThread2(list);
        thread2.setName("B");
        thread2.start();
        Thread.sleep(6000);
        System.out.println("listSize=" + list.getSize());
    }
}
