package com.dbright.easyexcel.test;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.metadata.Sheet;
import com.dbright.easyexcel.listener.ExcelListenerJHA;
import com.dbright.easyexcel.model.Employee;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class test {

    public static String sheetName;

    public static void main(String[] args) throws IOException {

        String excelName = "/root/BlogImg/员工表.xlsx";
        File file = new File(excelName);
        try {
            // 解析每行结果在listener中处理
            ExcelListenerJHA listener = new ExcelListenerJHA();
            //每解析一行就会进一次listener
            InputStream inputStream = new FileInputStream(file);
            EasyExcelFactory.readBySax(inputStream, new Sheet(1, 1, Employee.class), listener);
            listener.processDatas();//处理数据并进行入库操作
            inputStream.close();//关闭流
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
