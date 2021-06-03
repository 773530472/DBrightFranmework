package com.dbright.tcpTest;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TestTCPReceive {

    private InputStream is;

    public static void main(String[] args) {
        Socket socket = null;

        try {
            //对服务端发起连接请求
            socket = new Socket("localhost", 7777);

            //接收服务端并进行数据处理
            InputStream is = socket.getInputStream();
            byte[] bytes = new byte[1024];
            is.read(bytes);
            System.out.println(new String(bytes));
            //给服务端发送响应信息
            OutputStream os = socket.getOutputStream();
            os.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
