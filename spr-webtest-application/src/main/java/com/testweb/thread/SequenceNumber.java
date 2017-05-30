package com.testweb.thread;

/**
 * ThreadLocal实例
 * Created by Administrator on 2017/5/30.
 */
public class SequenceNumber {
    private static ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    public int getNextNum(){
        seqNum.set(seqNum.get()+1);
        return seqNum.get();
    }

    public static void main(String[] args) {
        SequenceNumber sn = new SequenceNumber();
        TestClient testClient1= new TestClient(sn);
        TestClient testClient2= new TestClient(sn);
        TestClient testClient3= new TestClient(sn);

        testClient1.start();
        testClient2.start();
        testClient3.start();

    }


    private static class TestClient extends Thread{
        private SequenceNumber sn;

        public TestClient(SequenceNumber sn){
            this.sn = sn;
        }

        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                System.out.println("thread["+Thread.currentThread().getName()+"]sn["+sn.getNextNum()+"]");
            }
        }
    }

}

