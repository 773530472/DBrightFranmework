package com.dbright.设计模式.SingleCase单例;

public class SingletonMain {
    public static void main(String[] args) {
        ehanSingleton singleton = ehanSingleton.getInstance();
        singleton.setReadings(singleton.getReadings()+1);
        read(singleton);
        singleton.setCollects(singleton.getCollects()+1);
        singleton.setLikes(singleton.getLikes()+1);
        System.out.println("阅读量为："+singleton.getReadings());
        System.out.println("收藏量为："+singleton.getCollects());
        System.out.println("点赞量为："+singleton.getLikes());

    }
    public static void read(ehanSingleton singleton){
        for (int i=0;i<100;i++){
            singleton.setReadings(singleton.getReadings()+1);
        }
    }
}
