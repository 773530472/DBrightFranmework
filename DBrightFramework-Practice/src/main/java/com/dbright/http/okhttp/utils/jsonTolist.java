package com.dbright.http.okhttp.utils;

import com.alibaba.fastjson.JSONArray;
import java.util.List;
import java.util.Map;

public class jsonTolist {
public static List<Map<String,String>> jsontolist(String json) {
    List<Map<String, String>> listObjectFir = (List<Map<String, String>>) JSONArray.parse(json);
    System.out.println("利用JSONArray中的parse方法来解析json数组字符串");
    for (Map<String, String> mapList : listObjectFir) {
        for (Map.Entry entry : mapList.entrySet()) {
            System.out.println(entry.getKey() + "  " + entry.getValue());
        }
    }
            return listObjectFir;
  }
}
