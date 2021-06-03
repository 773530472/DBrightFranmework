package com.dbright.Java反射;

import java.lang.annotation.ElementType;

public class ReflectionTest {
    public static void main(String[] args) throws Exception{
//        Person person = new Person();
//
//        //通过实例化对象获取class对象
//        Class c1 = person.getClass();
//        System.out.println("c1 "+c1.hashCode());
//
//        //通过类.Class获取class对象
//        Class c2 = Person.class;
//        System.out.println("c2 "+c2.hashCode());
//
//        //通过forName获取class对象
//        Class c3 = Class.forName("com.dbright.Java反射.Person");
//        System.out.println("c3 "+c3.hashCode());
//
//        //通过类名.Type
//        Class c4 = Integer.TYPE;
//        Class c41 = Integer.class;
//        System.out.println("c4 "+c4.hashCode());
//        System.out.println("c41 "+c41.hashCode());
//
//        //对象.getSuperclass()
//        Class c5 = c1.getSuperclass();
//        System.out.println("c5 "+c5.hashCode());

        Class c1 = Object.class;  //类 class java.lang.Object
        Class c2 = Comparable.class;  //接口 interface java.lang.Comparable
        Class c3 = String[].class;  //一维数组 class [Ljava.lang.String;
        Class c4 = int[][].class;  //二维数组 class [[I
        Class c5 = Override.class;  //注解 interface java.lang.Override
        Class c6 = ElementType.class;  //枚举 class java.lang.annotation.ElementType
        Class c7 = Integer.class;  //基本数据类型 class java.lang.annotation.ElementType
        Class c8 = void.class;  //void void
        Class c9 = Class.class;  //Class class java.lang.Class

        //Alt + 左键：全选后复制粘贴
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);
        System.out.println(c5);
        System.out.println(c6);
        System.out.println(c7);
        System.out.println(c8);
        System.out.println(c9);

        //只要元素类型与唯独一样，就是同一个Class
        int[] a = new int[10];
        int[] b = new int[100];
        System.out.println(a.getClass().hashCode());
        System.out.println(b.getClass().hashCode());
    }
}
