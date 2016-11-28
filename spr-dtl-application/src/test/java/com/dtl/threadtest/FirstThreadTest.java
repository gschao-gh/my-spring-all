package com.dtl.threadtest;

import com.dtl.thread.FirstThread;

/**
 * @author gschao
 * @date 2016/11/28 13:41.
 */
public class FirstThreadTest{
    public static void main(String[] args) {
        for (int i = 0; i <100 ; i++) {
            System.out.println(Thread.currentThread().getName()+" "+i);
            if(i==20){
                new FirstThread().start();
                new FirstThread().start();
            }
        }
    }

}
