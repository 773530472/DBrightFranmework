package com.dbright.Java多线程;

/**
 * 多线程的实现方式一 ：继承Tread类，并重写run方法,创建实例调用start方法
 */
public class TestThread extends Thread{

    //idea中快速重现父类方法的快捷键是 ctrl + o
    @Override
    public void run() {
        System.out.println("我是一个线程呀~~~~");
    }

    public static void main(String[] args) {
        //实例化线程实现类
        TestThread testTread = new TestThread();
        //使用start()方法启动该线程，无需调用run方法，因为在线程中他会默认调用run()方法，也就是启动后会自动执行run()方法
        testTread.start();
    }
}
