package com.dbright.java面试题.基础;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class testArray {
    public static void main(String[] args) {
        Integer[] intArr  = new Integer[]{1,2,6,3,2,0};
        Set set = new HashSet(Arrays.asList(intArr));
        System.out.println("数组转set=" + set.toString());
    }
}
