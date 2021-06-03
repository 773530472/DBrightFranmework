package com.dbright.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class test1000 {
    public static void main(String[] args) {
//        DecimalFormat df1 = new DecimalFormat("#.00");
//        double c = 0.71233;
//        BigDecimal bg = new BigDecimal(c*100).setScale(2, RoundingMode.UP);
//        System.out.println("2："+bg);
//        System.out.println("3："+df1.format(c*100));
//
//        DecimalFormat df = new DecimalFormat("#.00");
//        df.setRoundingMode(RoundingMode.HALF_UP);//四舍五入必须加这段
//        String entercode = df.format(c*100);
//        System.out.println("4："+entercode);
        double d = 0.125;
        //通过改变构造方法，就可以解决精度丢失问题
        double b = new BigDecimal(Double.toString(d*100)).setScale(2,RoundingMode.HALF_UP).doubleValue();
//        d = b.setScale(2,RoundingMode.HALF_UP).doubleValue();
        DecimalFormat df1 = new DecimalFormat("#.00");
        System.out.println(df1.format(b));
    }
}
