package com.dtl.thread;

/**
 * @author gschao
 * @date 2016/11/28 13:39.
 */
public class FirstThread extends Thread {

    private int i;

    @Override
    public void run(){
        for (; i < 100; i++) {
            System.out.println(getName()+" "+i);
        }    
    }



}
