package com.dtl.thread;

/**
 * @author gschao
 * @date 2016/11/28 14:28.
 */
public class SecondThread implements Runnable {
    private int i;

    public void run() {
        for ( ;i <100 ; i++) {
            System.out.println(Thread.currentThread().getName()+" "+i);
        }
    }
}
