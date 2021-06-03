package com.dbright.Utils.sortUtils;

import java.util.*;

public class ListMapSortUtils {
    public static void main(String[] args) {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("name", "p");
        map1.put("cj", "15");
        Map<String, Object> map2 = new HashMap<String, Object>();
        map2.put("name", "h");
        map2.put("cj", "2");
        Map<String, Object> map3 = new HashMap<String, Object>();
        map3.put("name", "f");
        map3.put("cj", "21");
        list.add(map1);
        list.add(map3);
        list.add(map2);
        //排序前 
        for (Map<String, Object> map : list) {
            System.out.println(map.get("cj"));
        }
        List<Map<String, Object>> list1 = sortList(list);
        //排序后
        System.out.println("-------------------");
        for (Map<String, Object> map : list1) {
            System.out.println(map.get("cj"));
        }
    }
    public static List<Map<String,Object>> sortList(List<Map<String,Object>> resultList){
        Collections.sort(resultList, new Comparator<Map<String, Object>>() {
            public int compare(Map<String, Object> o1, Map<String, Object> o2) {
                Integer list1 = Integer.valueOf(o1.get("cj").toString()) ;//list1是从你list里面拿出来的一个
                Integer list2 = Integer.valueOf(o2.get("cj").toString()) ; //list2是从你list里面拿出来的第二个name
                return list1.compareTo(list2);
            }
        });
        return resultList;
    }
}