package com.dbright.Test;

/**
 * @Author: YongJunDing
 * @Description:
 * @Date:Create：in 2020/4/16 下午4:47
 * @Modified By：
 */
public class testMain {
    public static void main(String[] args) {
        System.out.println(getValue(1));
//        System.out.println(dateTo("20200202"));
    }
    public static int getValue(int i) {
        int result = 0;
        switch (i) {
            case 1:
                result = result + i;
            case 2:
                result = result + i * 2;
            case 3:
                result = result + i * 3;
        }
        return result;
    }
    /**
    *@author DingYongJun
    *@date 2020-04-22 10:55
    *@return
    **/
    public static String dateTo(String date) {
        String year = date.substring(0,4);
        String month = date.substring(4,6);
        String day = date.substring(6,8);
        String dateformat = year+"-"+month+"-"+day;
        return dateformat;
    }
}
