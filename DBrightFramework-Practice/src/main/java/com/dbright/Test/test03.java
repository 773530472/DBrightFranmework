package com.dbright.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class test03 {
    public static void main(String[] args) throws Exception {

    Class c1 = Class.forName("reflection.User");

    User user = new User();
    c1 = user.getClass();
    c1 = User.class;

    // 获取类的名字
    System.out.println(c1.getName());  //获得报名 + 类名：reflection.User
    System.out.println(c1.getSimpleName());  //获取类名：User

    //获得类的属性
    Field[] fields = c1.getFields(); //只能找到public属性

    fields = c1.getDeclaredFields();  //找到全部的属性：
        for (Field field : fields) {
        System.out.println(field);
    }

    //获得指定属性的值
    Field name = c1.getDeclaredField("name");
        System.out.println(name);

    //获得类的方法
    Method[] methods = c1.getMethods();  //获得本类及父类的全部public方法
        for (Method method : methods) {
        System.out.println(method);
    }

    methods = c1.getDeclaredMethods(); //获得本类的所有方法
        for (Method method : methods) {
        System.out.println(method);
    }

    //获得指定方法
    Method getName = c1.getMethod("getName", null);
    Method setName = c1.getMethod("setName", String.class);
        System.out.println(getName);
        System.out.println(setName);

    //获得构造器
    Constructor[] constructors = c1.getConstructors();
        for (Constructor constructor : constructors) {
        System.out.println(constructor);
    }

    constructors = c1.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
        System.out.println("#" + constructor);
    }

    //获得指定的构造器
    Constructor constructor = c1.getConstructor(String.class, int.class, int.class);


    System.out.println(constructor);
    }
}
