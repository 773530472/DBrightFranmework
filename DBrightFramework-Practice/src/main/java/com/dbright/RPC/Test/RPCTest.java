package com.dbright.RPC.Test;

import com.dbright.RPC.intFance.HelloService;
import com.dbright.RPC.intFance.impl.HelloServiceImpl;
import com.dbright.RPC.object.RPCClient;
import com.dbright.RPC.server.Server;
import com.dbright.RPC.server.impl.ServiceCenter;

import java.io.IOException;
import java.net.InetSocketAddress;

public class RPCTest {
 
    public static void main(String[] args) throws IOException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Server serviceServer = new ServiceCenter(8088);
                    serviceServer.register(HelloService.class, HelloServiceImpl.class);
                    serviceServer.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        HelloService service = RPCClient.getRemoteProxyObj(HelloService.class, new InetSocketAddress("localhost", 8088));
        System.out.println(service.sayHi("test"));
    }
}