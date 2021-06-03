package com.dbright.http.okhttp.main;

import com.dbright.http.okhttp.utils.OKhttpUtils;

public class TestOKhttp {
    public static void main(String[] args) {
        try {
            OKhttpUtils.syncGet();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
