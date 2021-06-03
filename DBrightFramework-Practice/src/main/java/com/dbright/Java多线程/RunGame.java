package com.dbright.Java多线程;

public class RunGame implements Runnable{

    Integer track = 100;//赛道的长度
    String turtle = "乌龟";
    String rabbit = "兔子";
    String winner = "";//胜利者

    public static void main(String[] args) {
        RunGame runGame = new RunGame();

        //开启兔子比赛的线程
        new Thread(runGame, runGame.rabbit).start();
        //开启乌龟比赛的线程
        new Thread(runGame, runGame.turtle).start();
    }

    @Override
    public void run() {
        //使用Thread.currentThread().getName()获得当前的参赛者是谁
        String ballplayer = Thread.currentThread().getName();
        if (ballplayer.equals(rabbit)){
            //模拟兔子跑步的速度,兔子跑的快，定义为每秒跑两米
            for (int i=0;i<=track;i+=2){
                System.out.println(rabbit+"跑了"+i+"米");
                //因为兔子比较骄傲，当兔子跑到60米时，睡了一会觉，导致输掉比赛
                if (i==50){
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (i>=100){
                    winner = rabbit;
                    System.out.println(winner+"赢了！！！");
                }
            }
        }else if (ballplayer.equals(turtle)){
            //模拟乌龟跑步的速度,乌龟跑的慢，定义为每秒跑一米
            for (int i=0;i<=track;i++){
                System.out.println(turtle+"跑了"+i+"米");
                if (i>=100){
                    winner = turtle;
                    System.out.println(winner+"赢了！！！");
                }
            }
        }


    }
}
