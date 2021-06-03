package com.dbright.Java算法;

import java.util.ArrayList;
import java.util.List;

public class KMPtest {
    public static void main(String[] args) {
        String a = "abcdbbcavddsabcdabdegsd";
        String b = "abcdabd";

        char[] arr = a.toCharArray();
        char[] brr = b.toCharArray();

        //开始排序
        List<Integer> result = new ArrayList<>();
        for (int i=0;i<arr.length;i++){
            Integer k = i;
            for (int j=0;j<brr.length;j++){
                if (brr[j]==arr[i]){
                     result.add(i);
                     i+=1;
                     if (result.size()==brr.length){
                         return;
                     }
                }else {
                    result.clear();
                    i=k;
                    break;
                }
            }
        }

        System.out.println("111");
    }
}
