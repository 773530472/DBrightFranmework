package com.dbright.LeetCode;


import java.util.Arrays;

/**
* 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
*示例 1：

*输入：[-4,-1,0,3,10]
*输出：[0,1,9,16,100]
*示例 2：

*输入：[-7,-3,2,3,11]
*输出：[4,9,9,49,121]
*
* */
public class LeetCode3 {

    public static void main(String[] args) {
        int[] arr = new int[]{-7,-3,2,3,11};
        int[] arr1 = sortedSquares(arr);
        for(int i=0;i<arr1.length;i++){
            System.out.println(arr1[i]+",");
        }

    }
    public static int[] sortedSquares(int[] A) {
        int[] sortArr = new int[A.length];
        for (int i=0;i<A.length;i++){
            sortArr[i] = A[i]*A[i];
        }
        Arrays.sort(sortArr);
        return sortArr;
    }
}


