package com.ay.sqlserver.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 连接sqlserver数据库
 *@author DingYongJun
 *@date 2020/9/15
 */
@Mapper
public interface SqlserverRpcMapper {

    /**
     * 自控光温数据接入--黄岛港
     *@author DingYongJun
     *@date 2020/9/15
     *@param paramsMap
     *@return List<Map<String, Object>>
     */
    List<Map<String, Object>> getHDLightTem(Map<String, Object> paramsMap);

    /**
     * 自控光温数据接入--董家口港-摩科瑞
     *@author DingYongJun
     *@date 2020/9/15
     *@param paramsMap
     *@return List<Map<String, Object>>
     */
    List<Map<String, Object>> getDJKLightTem(Map<String, Object> paramsMap);

    /**
     * 自控光温数据接入--董家口港-实华
     *@author DingYongJun
     *@date 2020/9/15
     *@param paramsMap
     *@return List<Map<String, Object>>
     */
    List<Map<String, Object>> getDJKLightTem1(Map<String, Object> paramsMap);

}
