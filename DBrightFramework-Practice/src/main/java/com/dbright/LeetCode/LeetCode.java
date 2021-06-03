package com.dbright.LeetCode;


public class LeetCode {

    public static void main(String[] args) {
        int[] nums = {11,15,2,7};
        int target = 9;
        twoSum(nums,target);
        System.out.println();

    }
        public static int[] twoSum(int[] nums, int target) {
            int[] num = new int[2];
            for(int i=0;i<nums.length-1;i++){
                for(int j=1;j<nums.length;j++){
                    if(nums[i] + nums[j]==target & i!=j){
                        num[0]=i;
                        System.out.println(i+","+j);
                        num[1]=j;
                    }
                }
            }
            return num;
        }
}


