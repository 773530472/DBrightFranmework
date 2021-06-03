package com.dbright.tcpTest;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TestTCPSend {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        Socket socket = null;

        String msg = "你好,我是tcp服务端!";

        try {
            //构造ServerSocket实例，指定端口监听客户端的连接请求
            serverSocket = new ServerSocket(7777);
            //建立跟客户端的连接
            socket = serverSocket.accept();

            //向客户端发送消息
            OutputStream os = socket.getOutputStream();
            os.write(msg.getBytes());
            InputStream is = socket.getInputStream();

            //接收客户端的数据作一定的处理相应
            byte[] bytes = new byte[1024];
            is.read(bytes);
            System.out.println(new String(bytes));

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭socket
            serverSocket.close();
            socket.close();
        }

    }
}
