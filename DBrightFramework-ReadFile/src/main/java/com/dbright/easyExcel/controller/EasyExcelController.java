package com.dbright.easyexcel.controller;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.fastjson.JSON;
import com.dbright.easyexcel.model.UserDepartmentBens;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author: YongJunDing
 * @Description:
 * @Date:Create：in 2020/4/17 下午2:28
 * @Modified By：
 */
@Controller
@RequestMapping("/operateApi")
public class EasyExcelController {
    /**
     * @program: sdkclient
     * @description: 全员统计导出功能
     * @author: DingYongJun
     * @create: 2020-04-07 15:36
     **/
    @RequestMapping("/importExcel")
    @ResponseBody
    public void importExcel(@RequestParam Map<String, Object> paramsMap, HttpServletResponse response) throws IOException {
        List<Map<String,Object>> resultList = null;

        UserDepartmentBens userDepartmentBens = new UserDepartmentBens();
        List<String> dateList = new ArrayList<>();
        dateList.add("2018-09-12");
        dateList.add("2018-09-12");
        dateList.add("2018-09-12");
        userDepartmentBens.setDingjibumen(dateList);
        userDepartmentBens.setReal_name("考核要求人数");
        userDepartmentBens.setUser_id("日期");

        List<UserDepartmentBens> list = new ArrayList<>();
        list.add(userDepartmentBens);
        ServletOutputStream out = response.getOutputStream();
        ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX, true);
        String fileName = "全员信息统计表";
        Sheet sheet = new Sheet(1, 0,UserDepartmentBens.class);
        //设置自适应宽度
        sheet.setAutoWidth(Boolean.TRUE);
        // 第一个 sheet 名称
        sheet.setSheetName("全员信息统计");
        writer.write(list, sheet);
        //通知浏览器以附件的形式下载处理，设置返回头要注意文件名有中文
        response.setHeader("Content-disposition", "attachment;filename=" + new String( fileName.getBytes("gb2312"), "ISO8859-1" ) + ".xlsx");
        writer.finish();
        response.setContentType("multipart/form-data");
        response.setCharacterEncoding("utf-8");
        out.flush();
    }
}
