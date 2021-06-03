package com.dbright.java面试题.基础;

import java.io.File;

public class 字符串反转 {
    public static void main(String[] args) {
        //线程安全的，多线程中可以使用，但是效率比较低
        StringBuffer stringBuffer = new StringBuffer("12345");
        System.out.println("原来："+stringBuffer);
        stringBuffer.reverse();
        System.out.println("反转后："+stringBuffer);

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        //线程不安全的，一般只在单线程中使用，但是效率比较高
        StringBuilder stringBuilder = new StringBuilder("12345");
        System.out.println("原来："+stringBuilder);
        stringBuilder.reverse();
        System.out.println("反转后："+stringBuilder);

        //String 类的常用方法都有那些？
        String str = "abcdefg";
        //1.返回指定字符的索引
        Integer s = str.indexOf("e");
        System.out.println(s);

        String s1 =  str.toUpperCase();
        System.out.println(s1);


        File file = new File("/home/下载/test.txt");
    }
}
