package com.dbright.Java网络编程.TCP;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 客户端
 */
public class TcpUplodeFileClient {
    public static void main(String[] args) throws Exception{
        //1、创建一个Socket连接
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 7777);
        //2、创建一个输出流
        OutputStream os = socket.getOutputStream();
        //3、读取文件
        FileInputStream fis = new FileInputStream(new File("C:\\Users\\大大丁大大\\Desktop\\有用文件\\test.jpg"));
        //4、写出文件
        byte[] buffer = new byte[1024];
        int len;
        while ((len = fis.read(buffer)) != -1) {
            os.write(buffer, 0, len);
        }

        //通知服务器，我已经结束了
        socket.shutdownOutput();    //我已经传输完了！

        //确定服务器接收完毕，才能够断开连接
        InputStream inputStream = socket.getInputStream();
        //String byte[]
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer2 = new byte[1024];
        int len2;
        while ((len2 = inputStream.read(buffer2)) != -1) {
            baos.write(buffer2, 0, len2);
        }
        System.out.println(baos.toString());

        //5、关闭资源
        baos.close();
        inputStream.close();
        fis.close();
        os.close();
        socket.close();
    }

}
