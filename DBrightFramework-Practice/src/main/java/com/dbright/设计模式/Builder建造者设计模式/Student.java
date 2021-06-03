package com.dbright.设计模式.Builder建造者设计模式;

import lombok.Data;

@Data
public class Student {
    private String name;//姓名必填
    private String age;//年龄必填
    private String IDcard;//身份证号必填
    private String clothsColor;//衣服颜色可选填
    private String shoeBrand;//鞋子品牌可选

    //私有的构造函数，参数是：Builder类
    private Student(Builder builder){
        this.name = builder.name;
        this.age = builder.age;
        this.IDcard = builder.IDcard;
        this.clothsColor = builder.clothsColor;
        this.shoeBrand = builder.shoeBrand;
    }

    //公共的，私有的类 Builder
    public static class Builder{
        //参数和主类保持一致
        private String name;//姓名必填
        private String age;//年龄必填
        private String IDcard;//身份证号必填
        private String clothsColor;//衣服颜色可选填
        private String shoeBrand;//鞋子品牌可选

        //使用多个构造函数来控制其参数传值,返回的是
        //比如必填字段可以放在一个构造函数中
        public Builder(String name,String age,String IDcard){
            this.name = name;
            this.age = age;
            this.IDcard = IDcard;
        }

        //选填函数单独用方法来写，方便控制
        public Builder setClothsColor(String clothsColor){
            this.clothsColor = clothsColor;
            return this;
        }

        //选填函数单独用方法来写，方便控制
        public Builder setShoeBrand(String shoeBrand){
            this.shoeBrand = shoeBrand;
            return this;
        }

        //建立build方法，返回 Student
        public Student build(){
            return new Student(this);
        }
    }

}
