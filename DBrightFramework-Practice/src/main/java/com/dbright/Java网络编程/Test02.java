package com.dbright.Java网络编程;

import java.net.InetSocketAddress;

public class Test02 {
    public static void main(String[] args) {

        InetSocketAddress socketAddress = new InetSocketAddress("127.0.0.1",8080);
        System.out.println(socketAddress);

        //常用方法
        System.out.println(socketAddress.getAddress());//获得端口的ip；
        System.out.println(socketAddress.getHostName());//返回ip；
        System.out.println(socketAddress.getPort());//输出端口名；
    }
}
