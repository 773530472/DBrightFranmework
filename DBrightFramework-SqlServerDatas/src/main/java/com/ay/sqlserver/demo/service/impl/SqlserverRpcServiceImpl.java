package com.ay.sqlserver.demo.service.impl;

import com.ay.sqlserver.demo.mapper.SqlserverRpcMapper;
import com.ay.sqlserver.demo.service.SqlserverRpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 连接sqlserver数据库
 *@author DingYongJun
 *@date 2020/9/15
 */
@Service
public class SqlserverRpcServiceImpl implements SqlserverRpcService {

    @Autowired(required = false)
    SqlserverRpcMapper sqlserverRpcMapper;

    /**
     * 自控光温数据接入
     *@author DingYongJun
     *@date 2020/9/15
     *@param paramsMap
     *@return List<Map<String, Object>>
     */
    @Override
    public List<Map<String,Object>> getPortLightTem(Map<String, Object> paramsMap) {
        List<Map<String,Object>> resultList = new ArrayList<>();
        List<Map<String,Object>> MKRList = new ArrayList<>();
        List<Map<String,Object>> SHList = new ArrayList<>();
        //查询黄岛港的数据
        resultList = sqlserverRpcMapper.getHDLightTem(paramsMap);
        if (!CollectionUtils.isEmpty(resultList)){
            for (Map map : resultList){
                map.put("chuguanhao",9000+Integer.parseInt(map.get("Name").toString().substring(0,map.get("Name").toString().indexOf("#"))));
            }
        }
        //查询董家口港的数据-摩科瑞
                MKRList = sqlserverRpcMapper.getDJKLightTem(paramsMap);
                if (!CollectionUtils.isEmpty(MKRList)){
                    for (Map map : MKRList){
                        int tankCode = Integer.parseInt(map.get("Name").toString().substring(0,map.get("Name").toString().indexOf("#")));
                        if (tankCode<10){
                            map.put("chuguanhao","M0"+tankCode);
                        }else {
                            map.put("chuguanhao","M"+tankCode);
                        }

            }
            resultList.addAll(MKRList);
        }

        //查询董家口港的数据-实华
        SHList = sqlserverRpcMapper.getDJKLightTem1(paramsMap);
        if (!CollectionUtils.isEmpty(SHList)){
            for (Map map : SHList){
                int tankCode = Integer.parseInt(map.get("Name").toString().substring(0,map.get("Name").toString().indexOf("#")));
                map.put("chuguanhao","D"+10+tankCode);
            }
            resultList.addAll(SHList);
        }
        return resultList;
    }

}
