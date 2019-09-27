package com.hql.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

@Data
@TableName("student")
public class Student {
    private Integer id;

    private String userCode;

    private String userName;

    private String sex;

    private String age;
}