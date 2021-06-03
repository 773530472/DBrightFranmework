package com.dbright.LeetCode;
/*
游戏规则是这样的：你和你的朋友面前有一堆石子，你们轮流拿，一次至少拿一颗，最多拿三颗，谁拿走最后一颗石子谁获胜。
假设你们都很聪明，由你第一个开始拿，请你写一个算法，输入一个正整数 n，返回你是否能赢（true 或 false）。*/

public class leetCode6 {
    public static void main(String[] args) {
        int num =14;
        System.out.println(isWin(num));
    }
    public static boolean isWin(int num) {
        return num % 4 != 0;
    }
}
