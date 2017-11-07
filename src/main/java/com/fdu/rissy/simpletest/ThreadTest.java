package com.fdu.rissy.simpletest;

/**
 * @author lins13
 * @date 11/7/17 10:44 AM
 **/
public class ThreadTest {

    public static void main(String[] args) {
        //1. mythread和main交叉运行
//        MyThread thread = new MyThread();
//        thread.setName("myThread");
//        thread.start();
//        try {
//            for (int i = 0; i < 10; i++) {
//                int time = (int) (Math.random() * 1000);
//                Thread.sleep(time);
//                System.out.println("main=" + Thread.currentThread().getName());
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        //2. 执行start()方法的顺序不代表线程启动的顺序
//        MyThread t11 = new MyThread(1);
//        MyThread t12 = new MyThread(2);
//        MyThread t13 = new MyThread(3);
//        MyThread t14 = new MyThread(4);
//        MyThread t15 = new MyThread(5);
//        MyThread t16 = new MyThread(6);
//        MyThread t17 = new MyThread(7);
//        MyThread t18 = new MyThread(8);
//        MyThread t19 = new MyThread(9);
//        MyThread t110 = new MyThread(10);
//        MyThread t111 = new MyThread(11);
//        MyThread t112 = new MyThread(12);
//        MyThread t113 = new MyThread(13);
//
//        t11.start();
//        t12.start();
//        t13.start();
//        t14.start();
//        t15.start();
//        t16.start();
//        t17.start();
//        t18.start();
//        t19.start();
//        t110.start();
//        t111.start();
//        t112.start();
//        t113.start();
        //3. use synchronized to make var change safely
//        MyThread myThread = new MyThread();
//        Thread a = new Thread(myThread, "A");
//        Thread b = new Thread(myThread, "B");
//        Thread c = new Thread(myThread, "C");
//        Thread d = new Thread(myThread, "D");
//        Thread e = new Thread(myThread, "E");
//
//        a.start();
//        b.start();
//        c.start();
//        d.start();
//        e.start();

//        ALogin a = new ALogin();
//        a.start();
//        BLogin b = new BLogin();
//        b.start();
        //4. use System.out.println(count--), no synchronize issue
//        MyThread run = new MyThread();
//        Thread t1 = new Thread(run);
//        Thread t2 = new Thread(run);
//        Thread t3 = new Thread(run);
//        Thread t4 = new Thread(run);
//        Thread t5 = new Thread(run);
//        Thread t6 = new Thread(run);
//        Thread t7 = new Thread(run);
//        Thread t8 = new Thread(run);
//        Thread t9 = new Thread(run);
//        Thread t10 = new Thread(run);
//        t1.start();
//        t2.start();
//        t3.start();
//        t4.start();
//        t5.start();
//        t6.start();
//        t7.start();
//        t8.start();
//        t9.start();
//        t10.start();
//        MyThread myThread = new MyThread();
//        myThread.run();

        //5. this.isAlive = false, Thread.currentThread().isAlive() return running thread
//        CountOperate c = new CountOperate();
//        Thread t1 = new Thread(c);
//        System.out.println("main begin t1 isAlive=" + t1.isAlive());
//        t1.setName("A");
//        t1.start();
//        System.out.println("main end t1 isAlive=" + t1.isAlive());

         //System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getId());
//        try {
//            MyThread thread = new MyThread();
//            thread.start();
//            Thread.sleep(2000);
//            thread.interrupt();
//        } catch (InterruptedException e) {
//            System.out.println("main catch");
//            e.printStackTrace();
//        }
        //6. interrupted: clear state, isInterrupted: not clear
//        try {
//            MyThread thread = new MyThread();
//            thread.start();
//            Thread.sleep(1000);
//            thread.interrupt();
//            System.out.println("stop 1 ? = " + thread.isInterrupted());
//            System.out.println("stop 2 ? = " + thread.isInterrupted());
//        } catch (InterruptedException e) {
//            System.out.println("main catch");
//            e.printStackTrace();
//        }
//        System.out.println("end!");
        //try {
//            MyThread thread = new MyThread();
//            thread.start();
//            Thread.sleep(8000);
//            thread.stop();
//        } catch (InterruptedException e) {
//            System.out.println("main catch");
//            e.printStackTrace();
//        }
//        System.out.println("end!");
        //7. suspend & resume
//        try {
//            MyThread thread = new MyThread();
//            thread.start();
//            Thread.sleep(5000);
//            thread.suspend();
//            System.out.println("A= " + System.currentTimeMillis() + " i=" + thread.getI());
//            Thread.sleep(5000);
//            System.out.println("A= " + System.currentTimeMillis() + " i=" + thread.getI());
//
//            thread.resume();
//            Thread.sleep(5000);
//
//            thread.suspend();
//            System.out.println("B= " + System.currentTimeMillis() + " i=" + thread.getI());
//            Thread.sleep(5000);
//            System.out.println("B= " + System.currentTimeMillis() + " i=" + thread.getI());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        //8. suspend will hold the lock forever if no resume() is called
//        try {
//            final SynchronizedObject object = new SynchronizedObject();
//            Thread thread1 = new Thread() {
//                @Override
//                public void run() {
//                    object.printString();
//                }
//            };
//            thread1.setName("a");
//            thread1.start();
//            Thread.sleep(1000);
//            Thread thread2 = new Thread() {
//                @Override
//                public void run() {
//                    System.out.println("thread2 starts, no entering printString() method");
//                    System.out.println("printString() is locked");
//                    object.printString();
//                }
//            };
//            thread2.start();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        try {
//            MyThread thread = new MyThread();
//            thread.start();
//            Thread.sleep(1000);
//            thread.suspend();
//            System.out.println("main end!");
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        MyThread thread = new MyThread();
//        thread.start();
        //9. thread inherit priority from the thread who created them
//        System.out.println("main thread begin priority=" + Thread.currentThread().getPriority());
//        Thread.currentThread().setPriority(6);
//        System.out.println("main thread end priority=" + Thread.currentThread().getPriority());
//        MyThread1 thread1 = new MyThread1();
//        thread1.start();
//        for (int i = 0; i < 20; i++) {
//            MyThread1 thread1 = new MyThread1();
//            thread1.setPriority(5);
//            thread1.start();
//            MyThread2 thread2 = new MyThread2();
//            thread2.setPriority(6);
//            thread2.start();
//        }

//        try {
//            MyThread1 myThread1 = new MyThread1();
//            myThread1.setPriority(1);
//            myThread1.start();
//            MyThread2 myThread2 = new MyThread2();
//            myThread2.setPriority(10);
//            myThread2.start();
//            Thread.sleep(10000);
//            myThread1.stop();
//            myThread2.stop();
//            System.out.println("a=" + myThread1.getI());
//            System.out.println("b=" + myThread2.getI());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        //10. test daemon thread. once non-daemon threads all exit, so does daemon thread(GC)
        try {
            MyThread thread = new MyThread();
            thread.setDaemon(true);
            thread.start();
            Thread.sleep(5000);
            System.out.println("thread object will stop printing");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
