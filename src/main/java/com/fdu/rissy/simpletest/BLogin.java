package com.fdu.rissy.simpletest;

/**
 * @author lins13
 * @date 11/7/17 11:50 AM
 **/
public class BLogin extends Thread {
    @Override
    public void run() {
        LoginServlet.doPost("b", "bb");
    }
}
