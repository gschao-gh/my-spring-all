package com.dtl.thread.pipethread;

import com.sun.corba.se.pept.transport.ReaderThread;

import java.io.*;

/**
 * @author gschao
 * @date 2016/11/28 16:14.
 */
public class ReadThread extends Thread {
    private PipedReader pr;

//    用于包装管道流得BufferReader对象
    private BufferedReader br;

    public ReadThread(){}

    public ReadThread(PipedReader pr){
        this.pr = pr;
        this.br = new BufferedReader(pr);
    }


    public void run(){
        String buff = null;

        try {
//            逐行读取管道输入流中的内容
            while ((buff = br.readLine())!=null){
                System.out.println(buff);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (br!=null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        }


    }


}
