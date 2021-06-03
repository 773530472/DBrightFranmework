package com.dbright.Java反射;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class test {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, NoSuchFieldException {
        Class c1 = Class.forName("com.dbright.Java反射.Person");//forName获取
        Person person = new Person();
        Class c2 = person.getClass();//对象.class获取
        Class c3 = Person.class;//类.对象

        //获取类的名字
        System.out.println("c1"+c1.getName());
        System.out.println("c2"+c2.getName());
        System.out.println("c3"+c3.getName());

        System.out.println("简单："+c1.getSimpleName());

        System.out.println("* ****************************************************");
        //获取类的属性
        Field[] fields = c1.getFields();//只能获取public属性
        for (Field field : fields) {
            System.out.println("getFields:"+field);
        }
        Field[] fields1 = c1.getDeclaredFields();//获取所有属性
        for (Field field : fields1) {
            System.out.println("getDeclaredFields:"+field);
        }
        //获取指定名称的属性
        System.out.println("getDeclaredField:"+c1.getDeclaredField("name"));

        System.out.println("* ****************************************************");
        //获得类的方法--包含父类的方法
        Method[] methods = c1.getMethods();//只能获得公共方法
        for (Method method : methods) {
            System.out.println("getMethods:"+method);
        }
        Method[] methods1 = c1.getDeclaredMethods();//获得所有方法
        for (Method method : methods1) {
            System.out.println("getDeclaredMethods"+method);
        }
        //获得指定方法
        Method method = c1.getMethod("getName",null);//无参直接传个null即可
        Method method1 = c1.getMethod("setName", String.class);//带参传参数的对象即可
        System.out.println("获得指定方法1:"+method);
        System.out.println("获得指定方法2:"+method1);


        System.out.println("* ****************************************************");
        //获得构造器，注释不再加，和上面一致，公共和私有
        Constructor[] constructors = c1.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println("getConstructors:"+constructor);
        }
        Constructor[] constructors1 = c1.getDeclaredConstructors();
        for (Constructor constructor : constructors1) {
            System.out.println("getDeclaredConstructors:"+constructor);
        }
        //获取指定的构造器--根据参数来确定是哪一个构造器
        System.out.println("获取指定的构造器:"+c1.getConstructor());
        System.out.println("获取指定的构造器:"+c1.getConstructor(String.class));
    }
}
