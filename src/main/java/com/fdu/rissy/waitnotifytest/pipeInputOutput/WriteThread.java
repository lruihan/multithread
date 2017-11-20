package com.fdu.rissy.waitnotifytest.pipeInputOutput;

import java.io.PipedOutputStream;
import java.io.PipedWriter;

public class WriteThread extends Thread {

    private WriteData writeData;
    private PipedWriter out;

    public WriteThread(WriteData writeData, PipedWriter out) {
        this.writeData = writeData;
        this.out = out;
    }

    @Override
    public void run() {
        writeData.writeMethod(out);
    }
}
