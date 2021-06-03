package com.dbright.Java多线程;

/**
 * 线程礼让
 */
public class TestThreadComity implements Runnable{
    public static void main(String[] args) {
        TestThreadComity th = new TestThreadComity();
        new Thread(th,"线程1").start();
        new Thread(th,"线程2").start();
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"开始执行！");
        Thread.yield();
        System.out.println(Thread.currentThread().getName()+"结束执行！");
    }
}
