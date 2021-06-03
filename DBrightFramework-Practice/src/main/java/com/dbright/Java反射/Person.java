package com.dbright.Java反射;

import lombok.Data;

@Data
public class Person extends Object{
    private String name;
    private int high;
    private String like;
    public Integer age;

    public Person(){
    }

    private void priTest(String name){

    }
    public Person(String name){
        this.name = name;
    }

}
