package com.dbright.statiStical.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/TestDBright")
public class TestDBrightController {

    @ResponseBody
    @RequestMapping("/HelloWord")
    public String getAccident(@RequestParam Map<String, Object> paramsMap) {

        return "hello world";
    }
}
