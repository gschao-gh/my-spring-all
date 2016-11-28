package com.dtl.thread.pipethread;

import java.io.IOException;
import java.io.PipedWriter;

/**
 * @author gschao
 * @date 2016/11/28 16:26.
 */
public class WriteThread extends Thread{
    String[] books = {
        "java全能速查词典",
        "java报表开发技术",
        "j2EE核心模式",
        "java极限编程"
    };

    private PipedWriter pw;
    public WriteThread(){}
    public WriteThread(PipedWriter pw){
        this.pw = pw;
    }

    public void run(){
        try {
            for (int i = 0; i <100 ; i++) {
               pw.write(books[i%4]+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(pw!=null){
                    pw.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
