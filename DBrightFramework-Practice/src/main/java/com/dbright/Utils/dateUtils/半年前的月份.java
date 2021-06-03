package com.dbright.Utils.dateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class 半年前的月份 {
    public static void main(String[] args) {
        getDateBeforeMonth("2019-01",6);

    }
    public static String[] getDateBeforeMonth(String dateKey, Integer length){
        String[] arrData = new String[2];
         try {
            //dateKey是传进来的日期，length是所需要前推的月份
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
            Calendar c = Calendar.getInstance();
            Date nowMonth = format.parse(dateKey);
            c.setTime(nowMonth);
            c.add(Calendar.MONTH, -length);
            Date m3 = c.getTime();
            String mon3 = format.format(m3);
            System.out.println("过去"+length+"个月："+mon3);
            arrData[0] = mon3;
            arrData[1] = dateKey;
            return arrData;
            } catch (ParseException e) {
            e.printStackTrace();
         }
         return arrData;
    }
}
