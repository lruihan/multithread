package com.fdu.rissy.waitnotifytest.producer_consumer_test;

public class Run {

    //use notifyAll(), otherwise there will be fake death state
    public static void main(String[] args) throws InterruptedException {
        String lock = new String("");
        Producer producer = new Producer(lock);
        Consumer consumer = new Consumer(lock);
//        ProducerThread producerThread = new ProducerThread(producer);
//        ConsumerThread consumerThread = new ConsumerThread(consumer);
//        producerThread.start();
//        consumerThread.start();
        ProducerThread[] producerThreads = new ProducerThread[2];
        ConsumerThread[] consumerThreads = new ConsumerThread[2];
        for (int i = 0; i < 2; i++) {
            producerThreads[i] = new ProducerThread(producer);
            producerThreads[i].setName("Producer " + (i + 1));
            consumerThreads[i] = new ConsumerThread(consumer);
            consumerThreads[i].setName("Consumer " + (i + 1));
            producerThreads[i].start();
            consumerThreads[i].start();
        }
        Thread.sleep(5000);
        Thread[] threadArray = new Thread[Thread.currentThread().getThreadGroup().activeCount()];
        Thread.currentThread().getThreadGroup().enumerate(threadArray);
        for (int i = 0; i < threadArray.length; i++) {
            System.out.println(threadArray[i].getName() + " " + threadArray[i].getState());
        }
    }
}
