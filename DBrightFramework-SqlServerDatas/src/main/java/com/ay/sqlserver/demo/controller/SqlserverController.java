package com.ay.sqlserver.demo.controller;

import com.ay.sqlserver.demo.service.SqlserverRpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 青岛港对外接口
 *@author DingYongJun
 *@date 2020/9/7
 */
@RestController
@RequestMapping("/emQDPort")
public class SqlserverController {

    @Autowired(required = false)
    private SqlserverRpcService sqlserverRpcService;

    /**
     * 自控光温数据接入
     *@author DingYongJun
     *@date 2020/9/15
     *@param paramsMap
     *@return List<Map<String, Object>>
     */
    @RequestMapping(value = "/getPortLightTem", method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String, Object>> getPortLightTem(@RequestParam Map<String, Object> paramsMap) {
        List<Map<String, Object>> resultList = new ArrayList<>();
        try {
            resultList = sqlserverRpcService.getPortLightTem(paramsMap);
        } catch (Exception e) {
            throw e;
        }
        return resultList;
    }

}
