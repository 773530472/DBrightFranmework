package com.dbright.设计模式.SingleCase单例;

import lombok.Data;

//懒汉单例模式
@Data
public class lanhanSingleton {
    //其他的属性,举例用的
    private Integer readings = 0;//阅读量
    private Integer collects = 0;//收藏量
    private Integer likes = 0;//点赞量

    //将自身的实例化对象设置成一个属性，并且加上final，static关键字修饰
    private static lanhanSingleton singleton = null;

    //构造方法私有化---外部无法靠new来创建该对象
    private lanhanSingleton(){};

    //公共的静态方法返回该实例,方便外部调用,线程安全的1：同步代码块，效率低
    public static synchronized lanhanSingleton getInstance(){
        if (singleton == null){
            singleton = new lanhanSingleton();
        }
        return singleton;
    }

    //公共的静态方法返回该实例,方便外部调用,线程安全的2：DCL 双检查锁机制
    public static lanhanSingleton getInstance1(){
        synchronized(lanhanSingleton.class){
            //第一次检查instance是否被实例化出来，如果没有进入if块
            if (singleton == null){
                // 某个线程取得了类锁，实例化对象前第二次检查instance是否已经被实例化出来，如果没有，才最终实例出对象
                if (singleton == null){
                    singleton = new lanhanSingleton();
                }
            }
        }
        return singleton;
    }
}
