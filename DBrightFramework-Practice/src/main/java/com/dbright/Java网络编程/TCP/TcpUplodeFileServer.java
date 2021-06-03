package com.dbright.Java网络编程.TCP;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端
 */
public class TcpUplodeFileServer {
    public static void main(String[] args) throws Exception{
        //创建服务
        ServerSocket serverSocket = new ServerSocket(7777);
        //监听连接
        Socket socket = serverSocket.accept();
        //获取输入流
        InputStream is = socket.getInputStream();
        //文件输出
        FileOutputStream fos = new FileOutputStream(new File("test.jpg"));
        byte[] buffer = new byte[1024];
        int len;
        while ((len=is.read(buffer)) != -1){
            fos.write(buffer,0,len);
        }
        //通知客户端接收完毕
        OutputStream os = socket.getOutputStream();
        os.write("接收完成".getBytes());

        //千万记得关闭所有资源
        serverSocket.close();
        socket.close();
        is.close();
        os.close();
    }
}
