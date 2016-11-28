package com.dtl.threadtest;

import com.dtl.thread.JoinThread;

/**
 * @author gschao
 * @date 2016/11/28 15:13.
 */
public class JoinThreadTest {

    public static void main(String[] args) throws Exception {
        new JoinThread("新线程").start();

        for (int i = 0; i <100 ; i++) {
            if (i==20){
                JoinThread jt = new JoinThread("被join得线程");
                jt.start();
                jt.join();
            }

            System.out.println(Thread.currentThread().getName()+" "+i);
        }
        
    }

}
