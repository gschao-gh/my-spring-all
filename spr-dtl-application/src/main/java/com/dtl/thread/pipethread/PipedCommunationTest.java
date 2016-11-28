package com.dtl.thread.pipethread;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * @author gschao
 * @date 2016/11/28 16:34.
 */
public class PipedCommunationTest {

    public static void main(String[] args) {
        PipedWriter pw = null;
        PipedReader pr = null;

        pr = new PipedReader();
        pw = new PipedWriter();


        try {
            pw.connect(pr);

            new WriteThread(pw).start();
            new ReadThread(pr).start();


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
