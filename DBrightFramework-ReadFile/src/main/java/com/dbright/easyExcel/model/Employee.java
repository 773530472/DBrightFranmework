package com.dbright.easyexcel.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

/**
 * @Class Dangers
 * @Description TODO
 * @Author DingYongJun
 * @Date 20-1-10
 */
@Data
public class Employee extends BaseRowModel {

    @ExcelProperty(index = 0)
    private String yonghubianhao;
    @ExcelProperty(index = 1)
    private String name;
}
