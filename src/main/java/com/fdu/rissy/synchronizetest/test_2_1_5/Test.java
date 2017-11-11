package com.fdu.rissy.synchronizetest.test_2_1_5;

public class Test {

    //not only set() but get() also needs to be synchronzied. otherwise there will be dirty data if multiple vars
    public static void main(String[] args) {
        try {
            PublicVar publicVarRef = new PublicVar();
            ThreadA thread = new ThreadA(publicVarRef);
            thread.start();
            Thread.sleep(200);
            publicVarRef.getValue();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
