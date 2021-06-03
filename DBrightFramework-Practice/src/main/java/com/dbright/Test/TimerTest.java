package com.dbright.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
/**
*@author DingYongJun
*@date 2020-04-16 15:39
*@return
**/
public class TimerTest {

    public static void main(String[] args) throws Exception {
        String beginDate = "2020-01-01";//开始时间
        String endDate = "2020-08-31";//结束时间

        List<String> dateList = get_D_Plau(beginDate,endDate);
    }

    public static List<String> get_D_Plau(String beginDate, String endDate) throws Exception {
        List<String> resltList = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.setTime(sdf.parse(beginDate));

        for (long d = cal.getTimeInMillis(); d <= sdf.parse(endDate).getTime(); d = get_D_Plaus_1(cal)) {
            resltList.add(sdf.format(d));
        }
        return resltList;
    }
    public static long get_D_Plaus_1(Calendar c) {
        c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH) + 1);
        return c.getTimeInMillis();
    }
}