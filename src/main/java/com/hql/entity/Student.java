package com.hql.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.hql.config.annotation.Hql;
import lombok.Data;

/**
 * @author zhangzhijie
 */
@Data
@TableName("student")
public class Student {
    private Integer id;

    private String userCode;

    private String userName;

    private String sex;

    private String age;
}