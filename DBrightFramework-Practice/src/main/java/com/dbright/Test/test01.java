package com.dbright.Test;

public class test01 {

    static {
        System.out.println("我是main类的静态代码块。main类被加载啦~");
    }

    public static void main(String[] args) throws ClassNotFoundException {
//        B b = new B();
        //反射也会产生主动引用
//        Class bClass = B.class;
//        Class.forName("com.dbright.Test.B");
        //3.不会产生类的引用方法
//        System.out.println(B.b); //Main类被加载, 父类被加载, 2

//        B[] array = new B[5];

        System.out.println(B.M); //Main类被加载, 1
    }
}
class A{
    static int b = 2;

    static {
        System.out.println("父类A被加载~");
    }

}

class B extends A{

    static {
        System.out.println("子类B被加载~");
        b = 500;
    }
    static int m = 100;
    static final int M = 1;

}
