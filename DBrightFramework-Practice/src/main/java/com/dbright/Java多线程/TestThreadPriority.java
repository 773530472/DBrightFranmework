package com.dbright.Java多线程;

/**
 * 线程优先级，不一定成功
 */
public class TestThreadPriority {
    public static void main(String[] args) {
        MyPriority myPriority = new MyPriority();
        Thread t1 = new Thread(myPriority);
        Thread t2 = new Thread(myPriority);
        Thread t3 = new Thread(myPriority);
        Thread t4 = new Thread(myPriority);
        Thread t5 = new Thread(myPriority);
        Thread t6 = new Thread(myPriority);
        //先设置线程优先级
        t1.setPriority(1);
        t1.start();
        t2.setPriority(3);
        t2.start();
        t3.setPriority(6);
        t3.start();
        t4.setPriority(Thread.MAX_PRIORITY);//  优先级=10
        t4.start();
        t5.setPriority(Thread.MIN_PRIORITY);// 优先级=1
        t6.setPriority(9);
        t6.start();

        System.out.println("main");
    }
}

class MyPriority implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"---线程被执行了！---"+Thread.currentThread().getPriority());
    }
}