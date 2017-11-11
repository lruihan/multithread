package com.fdu.rissy.threadtest;

/**
 * @author lins13
 * @date 11/7/17 11:50 AM
 **/
public class ALogin extends Thread {

    @Override
    public void run() {
        LoginServlet.doPost("a", "aa");
    }
}
