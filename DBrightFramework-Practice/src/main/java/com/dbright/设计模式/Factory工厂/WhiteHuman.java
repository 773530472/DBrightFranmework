package com.dbright.设计模式.Factory工厂;

//白色人种
public class WhiteHuman implements Human{
    public void getclolor() {
        System.out.println("白人皮肤一般是白色的！");
    }

    public void talk() {
        System.out.println("白人一般说英语");
    }
}
