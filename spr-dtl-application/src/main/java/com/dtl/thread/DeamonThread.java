package com.dtl.thread;

/**
 * @author gschao
 * @date 2016/11/28 15:23.
 */
public class DeamonThread extends Thread {

    public void run(){
        for (int i = 0; i <1000 ; i++) {
            System.out.println(getName()+" "+i);
        }


    }
}
