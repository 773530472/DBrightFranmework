package com.dbright.Java多线程;

/**
 * 线程的状态
 */
public class TestThreadStatus{

    public static void main(String[] args) throws InterruptedException {
        //我们用lamda表达式来启动一个线程
        Thread th = new Thread(()->{
            for (int i = 0; i <5 ; i++) {
                try {
                    Thread.sleep(100);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("////////////////");
        });

        Thread.State state = th.getState();
        System.out.println("创建时线程的状态+"+state);//线程的状态

        th.start();//启动线程
        state = th.getState();
        System.out.println("启动时线程的状态+"+state);

        //只要线程不终止就输入线程状态
        while (state != Thread.State.TERMINATED){
            Thread.sleep(100);
            state = th.getState();
            System.out.println("new+"+state);
        }



    }

}
