package com.dbright.Java网络编程.UDP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 客户端
 */
public class UdpClient {
    public static void main(String[] args) throws Exception{
        //建立socket的同时也给自己绑定一个端口为8888
        DatagramSocket socket = new DatagramSocket(8888);

        //数据包，这里可以从控制台拿到
        //String msg = "你好，先生，首付8.8万的江北新区大三房考虑嘛？";
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            //获取控制台的数据并且将其转为字节数组
            byte[] msg = bufferedReader.readLine().getBytes();
            //发送给谁？
            InetAddress ip = InetAddress.getByName("127.0.0.1");
            int port = 7777;
            //参数分别是，数据包，起始位置，结束位置，ip，端口
            DatagramPacket packet = new DatagramPacket(msg,0,msg.length,ip,port);

            //开始发送
            socket.send(packet);
            //如果对方发送 拜拜 我们就断开
            if (bufferedReader.readLine().equals("拜拜")){
                break;
            }
        }
        //关闭连接
        socket.close();
    }
}
