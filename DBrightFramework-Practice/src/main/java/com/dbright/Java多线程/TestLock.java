package com.dbright.Java多线程;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用Lock锁
 */
public class TestLock {

    public static void main(String[] args) {
        TestLock2 testLock = new TestLock2();

        new Thread(testLock, "A").start();
        new Thread(testLock, "B").start();
        new Thread(testLock, "C").start();
    }

}

class TestLock2 implements Runnable{
    int count = 1000;

    //定义lock锁
    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while(true)
        {
            try {
                //进入加锁状态
                lock.lock();
                if(count > 0)
                    System.out.println(Thread.currentThread().getName() + "---" +count--);
                else
                    break;
            }
            finally {
                //解锁
                lock.unlock();
            }
        }
    }
}
