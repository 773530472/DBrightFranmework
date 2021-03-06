package com.dbright.zxing;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.io.File;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;


/**
 * 二维码生成
 *@author DingYongJun
 *@date 2020/5/8
 *@param
 *@return
 */
public class ZxingTest {

    public static BitMatrix orCode(Map<String,Object> parmsMap) {

        String path = parmsMap.get("path").toString();
        /*
         * 图片的宽度和高度
         */
        int width = 300;
        int height = 300;
        // 图片的格式
        String format = "png";   
 
        // 定义二维码的参数
        HashMap<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
        // 定义字符集编码格式
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        // 纠错的等级 L > M > Q > H 纠错的能力越高可存储的越少，一般使用M
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
        // 设置图片边距
        hints.put(EncodeHintType.MARGIN, 2);
        BitMatrix bitMatrix = null;
        try {
            // 最终生成 参数列表 （1.内容 2.格式 3.宽度 4.高度 5.二维码参数）
            bitMatrix = new MultiFormatWriter().encode(path, BarcodeFormat.QR_CODE, width, height, hints);
            return bitMatrix;
        } catch (Exception e) {
            e.printStackTrace();
            return bitMatrix;
        }
 
    }
 
}
