package com.fdu.rissy.waitnotifytest.stack_1;

public class Consumer {

    private MyStack myStack;

    public Consumer(MyStack myStack) {
        this.myStack = myStack;
    }

    public void popService() {
        System.out.println("pop=" + myStack.pop());
    }
}
