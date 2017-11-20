package com.fdu.rissy.waitnotifytest.pipeInputOutput;

import java.io.IOException;
import java.io.PipedOutputStream;
import java.io.PipedWriter;

public class WriteData {

    public void writeMethod(PipedWriter out) {
        try {
            System.out.println("write : ");
            for (int i = 0; i < 300; i++) {
                String outData = "" + (i + 1);
                out.write(outData);
                System.out.println(outData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
