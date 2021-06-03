package com.dbright.poiExport.utils;

import org.apache.commons.collections4.CollectionUtils;

import java.util.List;
import java.util.Map;

public class exclUtils {

    /**
     * 去除指定的字段，也就是不导出
     * @mapKey： 制定的不导出字段
     * @startList： 刚开始的数据集合
     *  **/
    public static List<Map<String,Object>> deleteMapKey(List<Map<String,Object>> startList,List<String> mapKey){

        //如果根据dao接口来查数据，可能有些字段并不需要导出，我门可以用map的remove方法去除该字段
        if (CollectionUtils.isNotEmpty(startList) || CollectionUtils.isNotEmpty(mapKey)) {
            for (int i = 0; i < mapKey.size(); i++) {
                for (int j = 0; j < startList.size(); j++) {
                    startList.get(j).remove(mapKey.get(i));
                }
            }
        }else {
            //如果传集合有一个为空，则返回空
            return null;
        }
        return startList;
    }

    /**
     * @判断选中状态
     * @paramsMap： 前端传的选中状态字段
     * @startList： 刚开始的数据集合
     * 隐患数量——yhsl，整改率——zgl，累计执法次数——ljzf  0为选中，1为未选中状态
     * **/
    public static List<Map<String,Object>> JudgeSelected(Map<String,Object> paramsMap, List<Map<String,Object>> startList, List<String> ifMapKey){

        if(CollectionUtils.isNotEmpty(startList) || CollectionUtils.isNotEmpty(ifMapKey)){
            for(int i=0;i<ifMapKey.size();i++){
                if(paramsMap.get(ifMapKey.get(i)).equals("1")){
                    startList.remove(ifMapKey.get(i));
                }
            }
        }else {
            return null;
        }
        return startList;
    }

}
