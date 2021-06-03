package com.dbright.controller;

import com.dbright.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Slf4j
@RestController
@RequestMapping("/setRedisUtils")
public class TestController {

    @Autowired
    private RedisUtil redisUtil;

    @GetMapping("/getName")
    public Map<String,Object> getName(@RequestParam Map<String, Object> paramsMap){
        Map<String,Object> resultMap =  new HashMap<String, Object>();
        resultMap.put("name",redisUtil.get(paramsMap.get("name").toString()));
        return resultMap;
    }

    @GetMapping(value = "/setName")
    public Object setName(@RequestParam Map<String, Object> paramsMap){
        String nameKey = getOrderIdByUUId();
        String nameValue = paramsMap.get("nameValue").toString();
        redisUtil.set(nameKey,nameValue);
        return "加入成功！";
    }

    @GetMapping(value = "/setList")
    public Map<String,Object> setList(@RequestParam Map<String, Object> paramsMap){
        Map<String,Object> resultMap = new HashMap<String, Object>();
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("name","丁大大");
        map.put("high","172");
        map.put("age","25");
        String nameKey = paramsMap.get("name").toString();
        redisUtil.lSet(nameKey,map);
        map.put("name","丁大大1");
        map.put("high","1721");
        map.put("age","251");
        redisUtil.lSet(nameKey,map);
        resultMap.put("status","加入成功");
        return resultMap;
    }

    @GetMapping("/getList")
    public Map<String,Object> getList(@RequestParam Map<String, Object> paramsMap){
        Map<String,Object> resultMap =  new HashMap<String, Object>();
        resultMap.put("name",redisUtil.lGet(paramsMap.get("name").toString(),0,-1));
        return resultMap;
    }

    @GetMapping("/deleteRedis")
    public Map<String,Object> deleteRedis(@RequestParam Map<String, Object> paramsMap){
        Map<String,Object> resultMap =  new HashMap<String, Object>();
        String parms = paramsMap.get("name").toString();
        redisUtil.del(parms);
        return resultMap;
    }

    @GetMapping("/getNo")
    public List<Map<String,Object>> getNo(@RequestParam Map<String, Object> paramsMap){
        List<Map<String,Object>> resultList = new ArrayList<Map<String, Object>>();
        Map<String,Object> resultMap =  new HashMap<String, Object>();
        resultMap.put("bianhao",getOrderIdByUUId());
        resultList.add(resultMap);
        return resultList;
    }

    public static String getOrderIdByUUId() {
        Date date=new Date();
        DateFormat format = new SimpleDateFormat("yyyyMMdd");
        String time = format.format(date);
        int hashCodeV = UUID.randomUUID().toString().hashCode();
        if (hashCodeV < 0) {//有可能是负数
            hashCodeV = -hashCodeV;
        }
        // 0 代表前面补充0
        // 4 代表长度为4
        // d 代表参数为正数型
        return time + String.format("%011d", hashCodeV);
    }

}