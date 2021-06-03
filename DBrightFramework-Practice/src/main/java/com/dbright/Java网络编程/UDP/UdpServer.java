package com.dbright.Java网络编程.UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 服务端
 */
public class UdpServer {
    public static void main(String[] args) throws Exception{
        //开发端口
        DatagramSocket socket = new DatagramSocket(7777);
        //接收数据包
        byte[] buffer = new byte[1024];

        while (true){
            DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);
            socket.receive(packet); //阻塞接收


            byte[] bytes = packet.getData();
            String msg = new String(bytes,0,bytes.length);
            System.out.println(msg);

            //断开连接
            if (msg.equals("拜拜")){
                break;
            }
        }
        //关闭连接
        socket.close();
    }

}
