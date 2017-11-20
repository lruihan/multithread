package com.fdu.rissy.waitnotifytest.pipeInputOutput;

import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PipedReader;

public class ReadThread extends Thread {

    private ReadData readData;
    private PipedReader in;

    public ReadThread(ReadData readData, PipedReader in) {
        this.readData = readData;
        this.in = in;
    }

    @Override
    public void run() {
        readData.readMethod(in);
    }
}
