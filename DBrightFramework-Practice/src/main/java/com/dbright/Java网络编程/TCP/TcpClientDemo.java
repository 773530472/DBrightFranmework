package com.dbright.Java网络编程.TCP;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 *客户端
 */
public class TcpClientDemo {
    public static void main(String[] args) {
        Socket socket = null;
        OutputStream os = null;

        //首先得知道服务端的地址和端口号
        //这里记得异常不要抛出去，捕获起来方便处理
        try {
            //服务器地址，用InetAddress来接收
            InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
            //端口号
            int port = 7777;
            //创建一个套接字链接（socket）
            socket = new Socket(inetAddress,port);
            //发送消息的时候要以io流的方式来发送，发送消息肯定是输出流啦
            os = socket.getOutputStream();

            //创建Scanner对象，接受从控制台输入
            Scanner input=new Scanner(System.in);
            //接受String类型
            String messge = input.next();

            //发送消息
            os.write(messge.getBytes(StandardCharsets.UTF_8));



        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //这里是重点！！！千万不要忘记关闭链接和流
            if (socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (os != null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
