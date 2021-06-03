package com.dbright.Test;

import java.util.ArrayList;
import java.util.List;

public class testString {
    public static void main(String[] args) {
        String str = "7#罐最高温度";

        String str1 = str.substring(0,str.indexOf("#"));
        System.out.println(str1);

        String str2 = "";


        //对图片进行处理
        List<String> picList = new ArrayList<>();
        String picStr = "adba43bea75f62fc950e454063336bb71f_LETS中化物流港(1).png,adba43bea75f62fc950e454063336bb71f_LETS中化物流港(1).png,adba43bea75f62fc950e454063336bb71f_LETS中化物流港(1).png";
        String[] arr = picStr.split(",");
        for (String s : arr){
            picList.add(s.substring(10,s.length()));
        }
        System.out.println("");
    }
}
