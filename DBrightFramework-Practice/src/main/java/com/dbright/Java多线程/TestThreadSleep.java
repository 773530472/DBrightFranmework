package com.dbright.Java多线程;

/**
 * 线程休眠 sleep
 */
public class TestThreadSleep implements Runnable{
    public static void main(String[] args) {
        TestThreadSleep th1 = new TestThreadSleep();
        new Thread(th1).start();
    }

    @Override
    public void run() {
        //模拟倒计时
        for (int i=10;i>0;i--){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }

    }
}

