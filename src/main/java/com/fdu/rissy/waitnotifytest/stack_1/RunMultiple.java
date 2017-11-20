package com.fdu.rissy.waitnotifytest.stack_1;

public class RunMultiple {

    //1. use while to check condition 2. use notifyAll()
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        Producer Producer1 = new Producer(myStack);
        Producer Producer2 = new Producer(myStack);
        Producer Producer3 = new Producer(myStack);
        Producer Producer4 = new Producer(myStack);
        Producer Producer5 = new Producer(myStack);
        Consumer consumer = new Consumer(myStack);
        ConsumerThread consumerThread1 = new ConsumerThread(consumer);
        ConsumerThread consumerThread2 = new ConsumerThread(consumer);
        ConsumerThread consumerThread3 = new ConsumerThread(consumer);
        ConsumerThread consumerThread4 = new ConsumerThread(consumer);
        ConsumerThread consumerThread5 = new ConsumerThread(consumer);

        ProducerThread ProducerThread1 = new ProducerThread(Producer1);
        ProducerThread ProducerThread2 = new ProducerThread(Producer2);
        ProducerThread ProducerThread3 = new ProducerThread(Producer3);
        ProducerThread ProducerThread4 = new ProducerThread(Producer4);
        ProducerThread ProducerThread5 = new ProducerThread(Producer5);
        ProducerThread1.start();
        ProducerThread2.start();
        ProducerThread3.start();
        ProducerThread4.start();
        ProducerThread5.start();
        consumerThread1.start();
        consumerThread2.start();
        consumerThread3.start();
        consumerThread4.start();
        consumerThread5.start();

    }
}
