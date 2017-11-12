package com.fdu.rissy.atomicIntegerTest;

public class Run {

    //AtomicInteger guarantees atomicity not synchronization(not thread-safe), still needs synchronized
    public static void main(String[] args) {

//        AddCountThread countService = new AddCountThread();
//        Thread t1 = new Thread(countService);
//        t1.start();
//        Thread t2 = new Thread(countService);
//        t2.start();
//        Thread t3 = new Thread(countService);
//        t3.start();
//        Thread t4 = new Thread(countService);
//        t4.start();
//        Thread t5 = new Thread(countService);
//        t5.start();


//        try {
//            MyService service = new MyService();
//            MyThread[] array = new MyThread[5];
//            for (int i = 0; i < array.length; i++) {
//                array[i] = new MyThread(service);
//            }
//            for (int i = 0; i < array.length; i++) {
//                array[i].start();
//            }
//            Thread.sleep(1000);
//            System.out.println(MyService.aiRef.get());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        try {
            Service service = new Service();
            ThreadA a = new ThreadA(service);
            a.start();
            Thread.sleep(1000);
            ThreadB b = new ThreadB(service);
            b.start();
            System.out.println("sent stop signal");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
