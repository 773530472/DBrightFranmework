package com.dbright.设计模式.Factory工厂;

//抽象人类创建工厂
public abstract class AbstractHumanFactory {
    public abstract <T extends Human> T createHuman(Class<T> c);
}
