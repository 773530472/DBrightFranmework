package com.dbright.RPC.intFance.impl;

import com.dbright.RPC.intFance.HelloService;

public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHi(String name) {
        return "Hi, " + name;
    }
 
}