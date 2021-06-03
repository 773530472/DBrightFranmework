package com.dbright.Java多线程;

/**
 * 使用状态标记来停止线程
 */
public class TestThreadDemo01 implements Runnable{
    public static void main(String[] args) throws Exception {
        TestThreadDemo01 threadDemo01 = new TestThreadDemo01();
        new Thread(threadDemo01).start();
        for (int i=0;i<1000;i++){
            System.out.println("主线程"+i);
            if (i==900){
                threadDemo01.stop();
                System.out.println("线程停止了！");
                break;
            }
        }
    }

    //状态标记
    private boolean flag = true;

    @Override
    public void run() {
        int i = 0;
        while (flag){
            System.out.println("线程！" + (i++));
        }
    }

    public void stop(){
        this.flag = false;
    }

}
