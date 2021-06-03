package com.dbright.easyExcel.Property;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

import java.io.Serializable;

@Data
public class Student extends BaseRowModel implements Serializable {
    public static final long serialVersionUID = 1L;
    @ExcelProperty(value = {"学号"}, index = 0)
    private String studentId;

    @ExcelProperty(value = {"姓名"}, index = 1)
    private String studentName;

    @ExcelProperty(value = {"准考证号"}, index = 2)
    private long examId;

    @ExcelProperty(value = {"身份证号"}, index = 3)
    private String idNumber;

    @ExcelProperty(value = {"班级Id"}, index = 4)
    private String classId;

    @ExcelProperty(value = {"性别"}, index = 5)
    private String gender;

    @ExcelProperty(value = {"出生日期"}, index = 6)
    private String birthday;

    @ExcelProperty(value = {"手机号"}, index = 7)
    private String phone;

}

