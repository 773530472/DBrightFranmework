package com.dbright.LeetCode;

public class LeetCode1 {

    public static void main(String[] args) {
//        String str = "abcabcbb";
        String str = "pwwkew";
//        System.out.println(str.length());
        System.out.println(lengthOfLongestSubstring(str));


    }
    public static int lengthOfLongestSubstring(String s) {
        byte[] sb = s.getBytes();
        //需要一个中间数值来记录相同的值
        int num = 1;
        int maxLength = 0;
        if (s.length()!=1) {
            for (int i = 0; i < sb.length - 1; i++) {
                for (int j = i + 1; j < sb.length; j++) {
                    if (sb[i] == sb[j]) {
                        String Middle = s.substring(i, j);
                        num = Middle.length();
                        break;
                    }else if(sb[i] != sb[j] & s.length()==2){
                        return 2;
                    }
                    if (sb[sb.length-2]!=sb[sb.length-1]){
                        return 2;
                    }
                }
                if (maxLength < num) {
                    maxLength = num;
                }
            }
        }else if (s.length()==0){
            maxLength = 0;
        }else {
            maxLength=1;
        }
        return maxLength;
    }
}


