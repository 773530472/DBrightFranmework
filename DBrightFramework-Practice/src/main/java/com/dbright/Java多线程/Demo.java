package com.dbright.Java多线程;

import lombok.SneakyThrows;

/**
 * 模拟多线程死锁的情况
 */
public class Demo {
    public static void main(String[] args) {
        DeadLockThread deadLockThread = new DeadLockThread();
        new Thread(deadLockThread,"丁一+").start();
        new Thread(deadLockThread,"丁二+").start();
    }
}

class DeadLockThread implements Runnable {
    A a = new A();
    B b = new B();

    @SneakyThrows
    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("丁一")){
            synchronized (this){
                System.out.println(Thread.currentThread().getName());
                a.soutA();
                Thread.sleep(2000);
                b.soutB();
            }
        }else {
            synchronized (this) {
                System.out.println(Thread.currentThread().getName());
                b.soutB();
                Thread.sleep(2000);
                a.soutA();
            }
        }
    }
}


class A {
    public void soutA(){
        System.out.println("我是A");
    }
}

class B {
    public void soutB(){
        System.out.println("我是B");
    }
}
