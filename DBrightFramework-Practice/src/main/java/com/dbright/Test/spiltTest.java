package com.dbright.Test;

import java.util.HashMap;
import java.util.Map;

public class spiltTest {
    public static void main(String[] args) {
//        String testStr = "测试";
//        Map<String,Object> resultMap = disposePoint(testStr);
//        System.out.println(resultMap);
        String str = "";
        String str1 = "12344";
        int status = str1.indexOf(str);
        System.out.println(status);
    }

    public static Map<String,Object> disposePoint(String pointStr){
        Map<String,Object> resultmap = new HashMap<>();
        if (!pointStr.equals("")){
            String[] xyArr = pointStr.split(",");
            if (xyArr.length>1){
                String x = xyArr[0];
                String y = xyArr[1];
                resultmap.put("x",x);
                resultmap.put("y",y);
            }else {
                resultmap.put("x","经纬度字段有误,请检查格式是否正确!");
                resultmap.put("y","经纬度字段有误,请检查格式是否正确!");
            }

        }else {
            resultmap.put("x","");
            resultmap.put("y","");
        }
        return resultmap;
    }
}
