package com.dbright.设计模式.Factory工厂;

//黄色人种
public class YellowHuman implements Human {
    public void getclolor() {
        System.out.println("黄种人皮肤一般是黄色的！");
    }

    public void talk() {
        System.out.println("黄种人一般说中文！");
    }
}
