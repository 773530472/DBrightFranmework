package com.dbright.easyExcel.EasyController;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.fastjson.JSON;
import com.dbright.easyExcel.Property.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ExportHandler {

//    @Autowired
//    private StudentAdminService studentAdminService;

    @GetMapping("/exportExcel")
    public void export(HttpServletResponse response) throws IOException {
//        List<Student> list = studentAdminService.queryAllStudent();
        Map<String,Object> map = new HashMap<>();
        map.put("studentId","153402");//学号
        map.put("studentName","丁大帅");//姓名
        map.put("examId","3426231442");//准考证号
        map.put("idNumber","34262319742839921");//身份证号
        map.put("classId","15234");//班级Id
        map.put("gender","男");//性别
        map.put("birthday","1995-10-01");//出生日期
        map.put("phone","18851688897");//手机号

        Student student = JSON.parseObject(JSON.toJSONString(map),Student.class);

        List<Student> reslutList = new ArrayList<>();
        reslutList.add(student);

        List<Student> list = new ArrayList<>();
        list.addAll(reslutList);

        ServletOutputStream out = response.getOutputStream();
        ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX, true);
        String fileName = "学生信息表";
        Sheet sheet = new Sheet(1, 0,Student.class);
        //设置自适应宽度
        sheet.setAutoWidth(Boolean.TRUE);
        // 第一个 sheet 名称
        sheet.setSheetName("学生信息");
        writer.write(list, sheet);
        //通知浏览器以附件的形式下载处理，设置返回头要注意文件名有中文
        response.setHeader("Content-disposition", "attachment;filename=" + new String( fileName.getBytes("gb2312"), "ISO8859-1" ) + ".xlsx");
        writer.finish();
        response.setContentType("multipart/form-data");
        response.setCharacterEncoding("utf-8");
        out.flush();
    }
}
