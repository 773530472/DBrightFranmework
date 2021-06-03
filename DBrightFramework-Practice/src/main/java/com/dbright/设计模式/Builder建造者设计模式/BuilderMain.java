package com.dbright.设计模式.Builder建造者设计模式;

public class BuilderMain {
    public static void main(String[] args) {
        Student student = new Student.Builder("丁大大","23","21798379873987329847")
                .setClothsColor("黑色")
                .setShoeBrand("耐克").build();
        System.out.println("姓名："+student.getName()+"\n年龄："+student.getAge()+"\n身份证号："+student.getIDcard()+"\n衣服颜色："+student.getClothsColor()+"\n鞋子品牌："+student.getShoeBrand());
    }
}
