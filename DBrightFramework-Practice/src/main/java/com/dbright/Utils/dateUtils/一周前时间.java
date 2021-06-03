package com.dbright.Utils.dateUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class 一周前时间 {
    public static void main(String[] args) {
       //调这个方法就是返回当前时间的一周前的零点零分零秒
        System.out.println(sevenDatysAgo());
    }
    public static String sevenDatysAgo(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        //过去七天
        c.setTime(new Date());
        c.add(Calendar.DATE, - 7);
        Date d = c.getTime();
        String day = format.format(d);
        day = day+" 00:00:00";
        return day;
    }
}
