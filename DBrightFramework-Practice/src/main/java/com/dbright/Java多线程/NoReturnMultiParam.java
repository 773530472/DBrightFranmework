package com.dbright.Java多线程;

public class NoReturnMultiParam {
    public static void main(String[] args) {
        //1.正常实现接口的方式
        FunInterImpl funInter = new FunInterImpl();
        funInter.method("1、实现类");
        System.out.println("***************************************");
        //2、静态内部类实现
        FunInterImpl funInter1 = new FunInterImpl();
        funInter.method("2、静态内部类");
        System.out.println("***************************************");
        //3.局部内部类
        class FunInterImpl2 implements FunInter{
            @Override
            public void method(String name) {
                System.out.println("我是实现类中的重写方法："+name);
            }
        }
        FunInterImpl2 funInterImpl2 = new FunInterImpl2();
        funInterImpl2.method("3、局部内部类");
        System.out.println("***************************************");
        //4.匿名内部类,要一分号;结尾
        FunInter funInter2 = new FunInter() {
            @Override
            public void method(String name) {
                System.out.println("我是实现类中的重写方法："+name);
            }
        };
        funInter2.method("4、匿名内部类");
        System.out.println("***************************************");
        //5.lamda表达式实现
        FunInter funInter3 = (String name) ->{
            System.out.println("我是实现类中的重写方法："+name);
        };
        funInter3.method("5.lamda表达式实现");
    }

    //2、静态内部类实现
    static class FunInterImpl implements FunInter{
        @Override
        public void method(String name) {
            System.out.println("我是实现类中的重写方法："+name);
        }
    }
}

/**
 * 这个注解是用来标注函数式接口的
 * 1.必须注解在接口上
 * 2.被注解的接口有且只有一个抽象方法
 * 3.被注解的接口可以有默认方法/静态方法，或者重写Object的方法
 */
@FunctionalInterface
interface FunInter{
    void method(String name);
}

/**
 * 1.正常接口实现类
 */
class FunInterImpl implements FunInter{

    //重写该方法
    @Override
    public void method(String name) {
        System.out.println("我是实现类中的重写方法："+name);
    }
}
