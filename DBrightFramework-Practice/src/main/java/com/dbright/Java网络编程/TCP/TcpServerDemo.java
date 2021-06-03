package com.dbright.Java网络编程.TCP;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *服务端
 */
public class TcpServerDemo {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        //首先建立一个服务端
        try {
            //1,ip地址
            serverSocket = new ServerSocket(7777);

            while (true) {
                //2、等待客户端连接
                socket = serverSocket.accept();
                //3.消息过来了我们得读取客户消息，接受消息肯定是输入流啦
                is = socket.getInputStream();

                //这个时候消息已经接受到了，我们怎么样读取呢？
                //管道输出流，ByteArrayOutputStream
                byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];//字节数组来接受
                int length;//长度
                while ((length = is.read(buffer)) != -1) {
                    byteArrayOutputStream.write(buffer, 0, length);
                }

                System.out.println(byteArrayOutputStream.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //同样的，得关闭流
            if (serverSocket != null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (byteArrayOutputStream != null){
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
