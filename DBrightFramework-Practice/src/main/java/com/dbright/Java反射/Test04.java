package com.dbright.Java反射;

import lombok.Data;

import java.lang.annotation.*;
import java.lang.reflect.Field;

public class Test04 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class c = Person1.class;

        //通过反射获取注解
        Annotation[] annotations = c.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println("annotation:"+annotation);
        }

        //获取注解的value的值
        classAno classAno1 = (classAno) c.getAnnotation(classAno.class);
        String value = classAno1.value();
        System.out.println("value:"+value);

        //获得类的指定注解
        Field field = c.getDeclaredField("name");
        methodAno methodAno1 = field.getAnnotation(methodAno.class);
        System.out.println("name:"+methodAno1.name());
        System.out.println("type:"+methodAno1.type());
        System.out.println("length:"+methodAno1.length());
    }
}

/**
 * 测试类
 */
@Data
@classAno("Person1")
class Person1{
    @methodAno(name = "丁大大",type = "超人类",length = 2)
    private String name;
    private int high;
    private String like;
    public Integer age;
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface classAno{
    String value();
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface methodAno{
    String name();
    String type();
    int length();
}


