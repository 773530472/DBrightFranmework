package com.dbright.Java多线程;

/**
 * 线程强制执行---插队
 */
public class TestThreadJoin implements Runnable {

    public static void main(String[] args) throws Exception {
        Thread thread = new Thread(new TestThreadJoin());
        for (int i = 0; i < 400; i++) {
            System.out.println("主线程在排队！！！" + i);
            if (i == 100) {
                thread.start();
                thread.join();

            }
        }
    }

    @Override
    public void run () {
        for (int i = 0; i < 100; i++) {
            System.out.println("VIP线程来插队了！！！" + i);
        }
    }
}
