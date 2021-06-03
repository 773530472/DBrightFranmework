package com.dbright.easyexcel.utils;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class poiReadUtils {

    public static int readSheetNums(String excelName) throws Exception {
        XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(new File(excelName)));
        int sheetNums = workbook.getNumberOfSheets();
        String sheetName = workbook.getSheetName(1);
        workbook.close();
        return sheetNums;
    }
    public static String readSheetName(String excelName,int sheetNums) throws Exception {
        XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(new File(excelName)));
        String sheetName = workbook.getSheetName(sheetNums-1);
        workbook.close();
        return sheetName;
    }
}
