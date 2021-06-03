package com.dbright.Java多线程;

/**
 * 手机抢购案例
 */
public class PhoneSnapUp implements Runnable {

    private Integer inventory = 10;//手机库存
    private boolean flag = true;

    public static void main(String[] args) {
        PhoneSnapUp phoneSnapUp = new PhoneSnapUp();
        //模拟5人同时抢购，即同时开启5个线程
        new Thread(phoneSnapUp, "丁大大1号").start();
        new Thread(phoneSnapUp, "丁大大2号").start();
        new Thread(phoneSnapUp, "丁大大3号").start();
        new Thread(phoneSnapUp, "丁大大4号").start();
        new Thread(phoneSnapUp, "丁大大5号").start();
    }

    @Override
    public void run() {
        while (flag){
            try {
                synchronized (this) {
                    buy();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //购票方法提出来
    private void buy() throws Exception {
        //当库存为0时，抢购结束
        if (inventory <= 0) {
            flag = false;
            return;
        }
        //模拟延迟，否则结果不容易看出来
        Thread.sleep(500);
        //每次抢购完，库存减1
        System.out.println("恭喜！！" + Thread.currentThread().getName() + "--抢到了一台小米12！库存还剩：" + --inventory + "台");
    }
}
