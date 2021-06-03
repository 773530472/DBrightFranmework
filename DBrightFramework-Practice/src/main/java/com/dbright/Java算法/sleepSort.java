package com.dbright.Java算法;

/**
 * dyj
 * 睡眠排序
 * */
public class sleepSort{
    public static void main(String[] args) {
        sortNums();
    }
    public static void sortNums(){
        int[] nums = new int[]{235, 233, 110, 789, 5, 0, 1};
        for (int item : nums) {
            new Thread(() -> {
                try {
                    Thread.sleep(item);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
                System.out.println(item);
            }).start();
        }
    }
}