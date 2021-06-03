package com.dbright.设计模式.Factory工厂;

//黑色人种
public class BlackHuman implements Human{

    public void getclolor() {
        System.out.println("黑人的皮肤一般都是黑色的！");
    }

    public void talk() {
        System.out.println("黑人一般说话一般人听不懂！");
    }
}
