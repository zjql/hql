package com.hql.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("user_table")
public class UserTable {

    private Integer id;

    private String name;

    private String password;

    private Date createTime;

    private String createPo;
}