package com.fdu.rissy.waitnotifytest.stack_1;

public class Run {

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        Producer producer = new Producer(myStack);
        Consumer consumer = new Consumer(myStack);
        ProducerThread producerThread = new ProducerThread(producer);
        ConsumerThread consumerThread = new ConsumerThread(consumer);
        producerThread.start();
        consumerThread.start();
    }
}
