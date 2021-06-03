package com.ay.sqlserver.demo.service;

import java.util.List;
import java.util.Map;

/**
 * 连接sqlserver数据库
 *@author DingYongJun
 *@date 2020/9/15
 */
public interface SqlserverRpcService {

    /**
     * 自控光温数据接入
     *@author DingYongJun
     *@date 2020/9/15
     *@param paramsMap
     *@return List<Map<String, Object>>
     */
    List<Map<String,Object>> getPortLightTem(Map<String, Object> paramsMap);

}
