package com.dbright.Java反射;

import java.lang.reflect.Method;

public class Test02 {
    public static void main(String[] args) throws NoSuchMethodException {
        test1();
        test2();
        test3();
    }

    /**
     *普通方式调用
     */
    public static void test1(){
        Person person = new Person();

        //获取当前系统时间
        long startTime = System.currentTimeMillis();
        for (int i=0; i<2000000000; i++){
            person.getName();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("普通方式调用所需时间："+(endTime-startTime)+"ms");
    }
    /**
     *反射方式调用
     */
    public static void test2() throws NoSuchMethodException {
        Person person = new Person();
        Class c = person.getClass();
        Method getName = c.getDeclaredMethod("getName",null);
        //获取当前系统时间
        long startTime = System.currentTimeMillis();
        for (int i=0; i<2000000000; i++){
            getName.getName();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("普通方式调用所需时间："+(endTime-startTime)+"ms");
    }
    /**
     *反射方式调用 关闭检测
     */
    public static void test3() throws NoSuchMethodException {
        Person person = new Person();
        Class c = person.getClass();
        Method getName = c.getDeclaredMethod("getName",null);
        //获取当前系统时间
        long startTime = System.currentTimeMillis();
        getName.setAccessible(true);//关闭安全检测
        for (int i=0; i<2000000000; i++){
            getName.getName();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("普通方式调用所需时间："+(endTime-startTime)+"ms");
    }

}
