package com.dbright.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class fenzu {
    public static void main(String[] args) {
        fun1();
    }
    public static void fun1() {
        List<Map<String,Object>> lsl = new ArrayList<>();

        Map<String,Object> map = new HashMap<>();
        map.put("id", "1");
        map.put("name", "zhangSan");
        lsl.add(map);

        Map<String,Object> map2 = new HashMap<>();
        map2.put("id", "2");
        map2.put("name", "lisi");
        lsl.add(map2);

        Map<String,Object> map3 = new HashMap<>();
        map3.put("id", "1");
        map3.put("name", "wangwu");

        lsl.add(map3);

        Map<String,Object> map4 = new HashMap<>();
        map4.put("id", "2");
        map4.put("name", "zhaoliu");

        lsl.add(map4);
        Function<Map<String,Object>, String>  s = new Function<Map<String,Object>, String>() {

            @Override
            public String apply(Map<String, Object> t) {
                Object object = t.get("id");
                String string = object.toString();
                return string;
            }
        };

        Map<String, List<Map<String, Object>>> collect = lsl.stream().collect(Collectors.groupingBy(s));

        System.out.println(collect);
    }


}
