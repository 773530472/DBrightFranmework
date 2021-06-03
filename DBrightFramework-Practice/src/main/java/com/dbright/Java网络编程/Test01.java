package com.dbright.Java网络编程;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Test01 {
    public static void main(String[] args) throws UnknownHostException {
        //使用InetAddress来获取
        InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
        System.out.println("inetAddress:"+inetAddress);

        //localhost和127.0.0.1是一样的
        InetAddress inetAddress1 = InetAddress.getByName("localhost");
        System.out.println("inetAddress1:"+inetAddress1);

        //getLocalHost方法获取本机ip地址
        InetAddress inetAddress2 = InetAddress.getLocalHost();
        System.out.println("inetAddress2:"+inetAddress2);

        //查询网站ip地址,这个稍微慢点，因为需要链接
        InetAddress inetAddress3 = InetAddress.getByName("www.baidu.com");
        System.out.println("inetAddress3:"+inetAddress3);

        //常用方法
        System.out.println(inetAddress.getCanonicalHostName());//规范的名字
        System.out.println(inetAddress.getHostAddress());  //ip
        System.out.println(inetAddress.getHostName()); //域名，或者自己电脑的名字

    }
}
