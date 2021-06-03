package com.dbright.Java多线程;

/**
 * 多线程的实现方式二 ：实现Runnable接口，并重写run方法,创建Thread时作为参数传入,调用start方法
 */
public class TestRunnable implements Runnable{
    public static void main(String[] args) {
        //分开写
        TestRunnable testRunnable = new TestRunnable();
        Thread tread = new Thread(testRunnable);
        tread.start();

        //简写
        new Thread(new TestRunnable()).start();
    }
    //和Thread一样，需要重写run()方法
    @Override
    public void run() {
        System.out.println("我也是一个线程呀~~~");
    }
}
