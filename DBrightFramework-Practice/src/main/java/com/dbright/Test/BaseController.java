package com.dbright.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: datascreen
 * @description: BaseController
 * @author: ChengQi
 * @create: 2019-05-05 10:27
 **/
public class BaseController {

    protected final Logger log = LoggerFactory.getLogger(this.getClass());
    /**
     * 获取数据成功
     *
     * <pre>
     * status = 200
     * data = data
     * message = “获取数据成功”
     * </pre>
     *
     * @param data 返回的数据
     * @return
     */
    protected Map<String, Object> formatReturnData(Object data) {
        Map<String, Object> formatReturnData = new HashMap<String, Object>();
        formatReturnData.put("status", 200);
        formatReturnData.put("data", data);
        formatReturnData.put("message", "获取数据成功");
        return formatReturnData;
    }

    /**
     * 获取数据失败
     *
     * <pre>
     * status = 500
     * data = null
     * message = 数据异常
     * errormsg = errormsg
     * </pre>
     *
     * @param errormsg 提示消息
     * @return
     */
    protected Map<String, Object> formatReturnData(String errormsg) {
        Map<String, Object> formatReturnData = new HashMap<String, Object>();
        formatReturnData.put("status", 500);
        formatReturnData.put("data", null);
        formatReturnData.put("message", "数据异常");
        formatReturnData.put("errormsg", errormsg);
        return formatReturnData;
    }

    protected Map<String, Object> formatReturnData(String errormsg, int status) {
        Map<String, Object> formatReturnData = new HashMap<String, Object>();
        switch (status) {
            case 200:
                formatReturnData.put("message", "获取数据成功");
                break;
            case 500:
                formatReturnData.put("message", "数据异常");
                break;
            default:
                formatReturnData.put("message", "");
                break;
        }
        formatReturnData.put("status", status);
        formatReturnData.put("data", null);
        formatReturnData.put("errormsg", errormsg);
        return formatReturnData;
    }

    /**
     * 获取数据成功
     *
     * <pre>
     * status = 200
     * data = data
     * message = “获取数据成功”
     * </pre>
     *
     * @param data 返回的数据
     * @return
     */
    protected Map<String, Object> formatReturnData(Object data, Object page) {
        Map<String, Object> formatReturnData = new HashMap<String, Object>();
        formatReturnData.put("status", 200);
        formatReturnData.put("data", data);
        formatReturnData.put("totalCount", page);
        formatReturnData.put("message", "获取数据成功");
        return formatReturnData;
    }

    /**
     * 获取数据成功
     *
     * <pre>
     * status = 200
     * data = data
     * message = “获取数据成功”
     * </pre>
     *
     * @param data 返回的数据
     * @return
     */
    protected Map<String, Object> formatReturnData(int status, Object data) {
        Map<String, Object> formatReturnData = new HashMap<String, Object>();
        formatReturnData.put("status", status);
        formatReturnData.put("data", data);
        formatReturnData.put("message", "获取数据成功");
        return formatReturnData;
    }

    /**
     * 获取数据成功
     *
     * <pre>
     * status = 200
     * data = data
     * message = “获取数据成功”
     * </pre>
     *
     * @param data 返回的数据
     * @return
     */
    protected Map<String, Object> formatReturnAppData(Object data) {
        Map<String, Object> formatReturnData = new HashMap<String, Object>();
        formatReturnData.put("status", 200);
        formatReturnData.put("result", data);
        return formatReturnData;
    }
    /**
     * 获取数据失败
     *
     * <pre>
     * status = 500
     * data = null
     * message = 数据异常
     * errormsg = errormsg
     * </pre>
     *
     * @param errormsg 提示消息
     * @return
     */
    protected Map<String, Object> formatReturnAppData(String errormsg) {
        Map<String, Object> formatReturnData = new HashMap<String, Object>();
        formatReturnData.put("status", 500);
        formatReturnData.put("result", null);
        formatReturnData.put("errormsg", errormsg);
        return formatReturnData;
    }

}