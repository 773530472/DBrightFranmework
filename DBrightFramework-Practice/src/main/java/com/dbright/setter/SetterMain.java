package com.dbright.setter;

public class SetterMain {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("丁大大").setAge(23).setLike("钓鱼");

        System.out.println("姓名："+student.getName()+"\n年龄："+student.getAge()+"\n爱好："+student.getLike());

    }
}
