package com.dbright.setter;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Student {
    //姓名
    private String name;
    //年龄
    private Integer age;
    //爱好
    private String like;
}
