package com.dtl.threadtest;

import com.dtl.thread.DeamonThread;

/**
 * @author gschao
 * @date 2016/11/28 15:25.
 */
public class DeamonThreadTest {

    public static void main(String[] args) {

        DeamonThread t = new DeamonThread();
        t.setDaemon(true);
        t.start();
        for (int i = 0; i <10 ; i++) {
            System.out.println(Thread.currentThread().getName()+" "+i);
        }

    }
}
