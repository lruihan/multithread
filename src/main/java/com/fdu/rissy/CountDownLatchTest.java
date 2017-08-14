package main.java.com.fdu.rissy;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

    public static void main(String[] args) {
        final CountDownLatch countDownLatch = new CountDownLatch(3);
        Service service1 = new Service("Service1", 50, countDownLatch);
        Service service2 = new Service("Service2", 100, countDownLatch);
        Service service3 = new Service("Service3", 150, countDownLatch);

        new Thread(service1).start();
        new Thread(service2).start();
        new Thread(service3).start();

        try {
            countDownLatch.await();
            System.out.println("main thread is ready!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class Service implements Runnable {

    private final String name;
    private final int timeToStart;
    private final CountDownLatch latch;

    public Service(String name, int timeToStart, CountDownLatch latch) {
        this.name = name;
        this.timeToStart = timeToStart;
        this.latch = latch;
    }

    @Override
    public void run() {

        try {
            Thread.sleep(timeToStart);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + " Service is up");
        latch.countDown();
    }
}
