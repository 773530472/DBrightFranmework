package com.dbright.Java反射;

import com.dbright.Test.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 通过反射动态的创建对象
 */
public class Test01 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {

        //获得class对象
        Class c = Class.forName("com.dbright.Java反射.Person");

        //构造一个对象，本质上是调用了无参构造器
        Person person = (Person) c.newInstance();
        System.out.println("person:"+person);

        //通过有参构造器创建对象
        Constructor constructor = c.getDeclaredConstructor(String.class);
        Person person1 = (Person) constructor.newInstance("ding");//需要重写tostring方法
        System.out.println("person1:"+person1);

        //通过反射获取和操作方法
        System.out.println("************************************************************");
        Person person2 = (Person) c.newInstance();
        Method setLike = c.getDeclaredMethod("setLike", String.class);
        setLike.invoke(person2,"钓鱼");
        System.out.println("person2:"+person2);

        //通过反射操作属性
        System.out.println("************************************************************");
        Person person3 = (Person) c.newInstance();
        Field name = c.getDeclaredField("name");

        //关掉权限检测：不能直接操作私有属性，我们需要关闭程序的安全检测，属性或者方法
        name.setAccessible(true);

        name.set(person3,"丁大大");
        System.out.println("name:"+name.getName());

    }
}
