package com.dtl.threadtest;

import com.dtl.thread.SecondThread;

/**
 * @author gschao
 * @date 2016/11/28 14:30.
 */
public class SecondThreadTest {


    public static void main(String[] args) {
        for (int i = 0; i <100 ; i++) {
            System.out.println(Thread.currentThread().getName()+" "+i);
            if(i==10){
                SecondThread st1 = new SecondThread();
                SecondThread st2 = new SecondThread();
                new Thread(st1,"新线程1：").start();
                new Thread(st2,"新线程2：").start();
            }
        }
        
    }

}
