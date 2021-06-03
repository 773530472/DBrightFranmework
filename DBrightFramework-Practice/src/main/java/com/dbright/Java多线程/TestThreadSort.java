package com.dbright.Java多线程;

/**
 * 测试线程的执行顺序
 */
public class TestThreadSort implements Runnable{
    public static void main(String[] args) {
        //使用实现Runnable方法的好处就是可以多实现
        TestThreadSort testThreadSort = new TestThreadSort();

        //开启线程1
        new Thread(testThreadSort,"丁大大").start();
        //开启线程2
        new Thread(testThreadSort,"甲大大").start();
        //开启线程3
        new Thread(testThreadSort,"乙大大").start();

        System.out.println("我是老师，我先看！");
    }

    @Override
    public void run() {
        //Thread.currentThread().getName() ---获取当前线程的名称
        for (int i=0;i<100;i++){
            System.out.println(Thread.currentThread().getName()+"看了第"+i+"本书");
        }
    }
}
