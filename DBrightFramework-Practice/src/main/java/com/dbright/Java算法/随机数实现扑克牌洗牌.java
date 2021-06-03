package com.dbright.Java算法;

import java.util.*;

public class 随机数实现扑克牌洗牌 {
    public static void main(String[] args) {
        ShuffleTheDeck();
    }

    //实现方式一  使用随机数 随机生成54个在1-54范围内的数字，当这些数字不重复时，完成洗牌
    public static void ShuffleTheDeck() {
        System.out.println("开始时间：" + new Date());
        List reslutList = new ArrayList();
        //开始随机洗牌
        int nums = 1;//计数器
        Random random = new Random();
        while (true) {
            int endRand = random.nextInt(54);
            reslutList.add(endRand + 1);
            if (ifRepeat(reslutList) == false) {
                reslutList.remove(reslutList.size() - 1);
            }

            if (reslutList.size() >= 54) {
                break;
            }
            nums++;
        }
        System.out.println("共随机了"+nums+"次");
        System.out.println("结束时间：" + new Date());
        for (int j = 0; j < reslutList.size(); j++) {
            System.out.println(reslutList.get(j).toString());
        }
    }

    //该方法是判断集合中是否有重复元素的,如果有返回false,反之返回true
    public static boolean ifRepeat(List list) {
        HashSet set = new HashSet<>(list);
        Boolean bool = set.size() == list.size() ? true : false;
        return bool;
    }
}
