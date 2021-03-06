package com.dbright.http.okhttp.utils;


import com.alibaba.fastjson.JSON;
import okhttp3.*;

import java.io.IOException;
import java.util.HashMap;

public class OKhttpUtils {
    /**
     * 同步get请求
     */
    public static void syncGet() throws Exception{
        String urlBaidu = "http://127.0.0.1:9015/sdkem/EmReFaclityOneMap/getFaclityInfo?entId=zhonghuazhoushan&shebeimingcheng=消防炮,起重机";
        OkHttpClient okHttpClient = new OkHttpClient(); // 创建OkHttpClient对象
        Request request = new Request.Builder().url(urlBaidu).build(); // 创建一个请求
        Response response = okHttpClient.newCall(request).execute(); // 返回实体
        if (response.isSuccessful()) { // 判断是否成功
            /**获取返回的数据，可通过response.body().string()获取，默认返回的是utf-8格式；
             * string()适用于获取小数据信息，如果返回的数据超过1M，建议使用stream()获取返回的数据，
             * 因为string() 方法会将整个文档加载到内存中。*/
            String str = response.body().string();
            HashMap hashMap = JSON.parseObject(str, HashMap.class);
            System.out.println(str); // 打印数据
        /*    //测试
            List<Map<String,String>> resultList = new ArrayList<>();
            resultList = jsonTolist.jsontolist(CallEI.doGetTestOne());
            System.out.println("111");*/
        }else {
            System.out.println("失败"); // 链接失败
        }
    }

    /**
     * 异步Get请求
     */
    public static void asyncGet() {
        String urlBaidu = "http://www.baidu.com/";
        OkHttpClient okHttpClient = new OkHttpClient(); // 创建OkHttpClient对象
        Request request = new Request.Builder().url(urlBaidu).build(); // 创建一个请求
        okHttpClient.newCall(request).enqueue(new Callback() { // 回调

            public void onResponse(Call call, Response response) throws IOException {
                // 请求成功调用，该回调在子线程
                System.out.println(response.body().string());
            }

            public void onFailure(Call call, IOException e) {
                // 请求失败调用
                System.out.println(e.getMessage());
            }
        });
    }

}
