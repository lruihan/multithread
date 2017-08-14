package main.java.com.fdu.rissy.producer_consumer;

import java.util.LinkedList;

/**
 * Created by lins13 on 4/20/17.
 */
public class WaitNotifyTest {

    public static void main(String[] args) throws InterruptedException{

        ProducerConsumer producerConsumer = new ProducerConsumer();

        Thread producerThread = new Thread(() -> {
           try {
               producerConsumer.produce();
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
        });

        Thread consumerThread = new Thread(() -> {
            try {
                producerConsumer.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        producerThread.start();
        consumerThread.start();

//        producerThread.join();
//        consumerThread.join();
    }

    static class ProducerConsumer {

        LinkedList<Integer> list = new LinkedList<>();
        int capacity = 2;

        public void produce() throws InterruptedException {

            int value = 0;
            while(true) {
                synchronized (this) {
                    while(list.size() == capacity) {
                        wait();
                    }
                    System.out.println("Producer produce-" + value);
                    list.add(value++);
                    notify();
                    Thread.sleep(1000);
                }
            }
        }

        public void consume() throws InterruptedException {
            while(true) {
                synchronized (this) {
                    while(list.size() == 0) {
                        wait();
                    }
                    int val = list.removeFirst();
                    System.out.println("Consumer consumed-" + val);
                    notify();
                    Thread.sleep(1000);
                }
            }
        }

    }
}

