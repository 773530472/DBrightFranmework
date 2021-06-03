package com.dbright.设计模式.SingleCase单例;

import lombok.Data;
import lombok.experimental.Accessors;

//饿汉单例模式
@Data
@Accessors(chain = true)
public class ehanSingleton {
    //其他的属性,举例用的
    private Integer readings = 0;//阅读量
    private Integer collects = 0;//收藏量
    private Integer likes = 0;//点赞量

    //将自身的实例化对象设置成一个属性，并且加上final，static关键字修饰
    private static final ehanSingleton singleton = new ehanSingleton();

    //构造方法私有化---外部无法靠new来创建该对象
    private ehanSingleton(){};

    //公共的静态方法返回该实例,方便外部调用
    public static ehanSingleton getInstance(){
        return singleton;
    }
}
