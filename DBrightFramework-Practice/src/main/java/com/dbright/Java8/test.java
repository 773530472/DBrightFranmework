package com.dbright.Java8;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: YongJunDing
 * @Description:
 * @Date:Create：in 2020/4/26 下午1:52
 * @Modified By：
 */
public class test {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("6");
        list.add("3");
        list.add("4");
        list.add("7");
        list.add("1");

//        for (String s : list){
//            System.out.println("s");
//        }

        list.stream().forEach(string -> list.toString());

        Collections.sort(list,(a,b) -> a.compareTo(b));

        for (String s : list){
            System.out.println(s);
        }

    }
}
