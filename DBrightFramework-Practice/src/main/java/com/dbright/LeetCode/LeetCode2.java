package com.dbright.LeetCode;

public class LeetCode2 {

    public static void main(String[] args) {
//        String str = "abcabcbb";
        String str = "pwwkew";
//        System.out.println(str.length());
        System.out.println(lengthOfLongestSubstring(str));


    }
    public static int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int max = 0;
        if (chars.length == 0) {
            return 0;
        } else if (chars.length == 1) {
            return 1;
        }
        //重复的坐标
        int len = 0;
        for (int j=0; j <chars.length ; j++) {
            for (int k = len;  k<j ; k++) {
                if (chars[j] == chars[k]) {
                    len = k+1 ;
                    break;
                }
            }
            if (max<j-len+1){
                max=j-len+1;
            }else {
                max=max;
            }
        }
        return max;
    }
}


