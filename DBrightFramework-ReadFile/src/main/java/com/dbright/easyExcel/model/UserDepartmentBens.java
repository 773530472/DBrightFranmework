package com.dbright.easyexcel.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class UserDepartmentBens extends BaseRowModel implements Serializable {

    public static final long serialVersionUID = 1L;

    @ExcelProperty(value = {"登录统计","部门","部门",""}, index = 0)
    private String real_name;

    @ExcelProperty(value = {"登录统计","考核要求人数","考核要求人数",""}, index = 1)
    private String user_id;

    @ExcelProperty(value = {"登录统计","登录数/登录率","登录数/登录率",""}, index = 2)
    private List<String> dingjibumen;

    @ExcelProperty(value = {"登录统计","登录数/登录率","登录数/登录率","2018"}, index = 2)
    private List<String> dingjibumen1;

    @ExcelProperty(value = {"登录统计","登录数/登录率","登录数/登录率","2019"}, index = 2)
    private List<String> dingjibumen2;

    @ExcelProperty(value = {"登录统计","登录数/登录率","登录数/登录率","2020"}, index = 2)
    private List<String> dingjibumen3;

}

