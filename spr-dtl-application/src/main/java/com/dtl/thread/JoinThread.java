package com.dtl.thread;

/**
 * @author gschao
 * @date 2016/11/28 15:06.
 */
public class JoinThread extends Thread {

    public JoinThread(String name){
        super(name);
    }

    @Override
    public void run(){
        for (int i = 0; i < 100; i++) {
            System.out.println(getName()+" "+i);
        }
    }

}
