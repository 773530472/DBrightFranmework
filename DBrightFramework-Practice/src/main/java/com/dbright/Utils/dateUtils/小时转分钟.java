package com.dbright.Utils.dateUtils;

public class 小时转分钟 {
    public static void main(String[] args) {
        String str = "3小时24分";
        System.out.println(str+":"+hoursTOminute(str));
    }

    public static int hoursTOminute(String date) {
        String[] dataArr = date.split("小时");
        int Hminute = Integer.parseInt(dataArr[0]) * 60;
        int Mminute = Integer.parseInt(dataArr[1].replace("分",""));
        int hoursToMinute = Hminute + Mminute;
        return hoursToMinute;
    }
}
