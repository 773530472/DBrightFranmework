package com.dbright.java注解;


import java.lang.annotation.*;

@SuppressWarnings("all")
public class Annotation1 extends Object{
    public static void main(String[] args) {

    }
    @myAnnotation(like = "钓鱼")
    public static void testSuppressWarnings(){
    }
}

@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.METHOD)
@Inherited
@interface myAnnotation {
    String name() default "";
    int age() default 18;
    String like();
    String IDCard() default "";
}

