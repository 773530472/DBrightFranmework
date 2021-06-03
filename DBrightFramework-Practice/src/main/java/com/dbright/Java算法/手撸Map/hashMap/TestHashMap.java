package com.dbright.Java算法.手撸Map.hashMap;

import java.util.HashMap;
import java.util.Map;

public class TestHashMap {
    public static void main(String[] args) {
        Map<String,Object> map = new HashMap<>();
        map.put("1","1");
        MyMap<String,Object> myMap = new hashMapImpl<>();
        myMap.put("1","1");
        myMap.put("2","3");
        myMap.put("3","4");
        myMap.put("4","5");

        for (int i=1;i<5;i++){
            System.out.println(myMap.get(i+"").toString());
        }

        for (String s : map.keySet()){
//            System.out.println(s);
        }
    }
}
