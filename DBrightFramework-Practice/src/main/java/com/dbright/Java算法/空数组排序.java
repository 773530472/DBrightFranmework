package com.dbright.Java算法;

public class 空数组排序 {
    public static void main(String[] args) {
        int[] sortArr = new int[100];
        int[] intArr = new int[]{8,1,17,42,5,34};
        int[] reslutArr = new int[intArr.length];
        for (int i=0;i<intArr.length;i++){
            sortArr[intArr[i]] = intArr[i];
        }
        int j = 0;
        for (int i=0;i<sortArr.length;i++){
            if (sortArr[i] != 0){
                reslutArr[j] = sortArr[i];
                j++;
            }
        }
        for(int i : reslutArr){
            System.out.println(i);
        }
    }
}
