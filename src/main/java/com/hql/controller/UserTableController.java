package com.hql.controller;

import com.hql.entity.UserTable;
import com.hql.service.UserTableService;
import com.sun.org.apache.regexp.internal.REUtil;
import org.apache.logging.log4j.message.ReusableMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 开发者中文姓名
 * @date 2019/9/23 17:07
 */
@RestController
@RequestMapping("/user")
public class UserTableController {

    @Autowired
    private UserTableService userTableService;

    @RequestMapping("/query/{userId}")
    public List<UserTable> queryUserTable(int userId){
        return userTableService.queryAllUserTableId(userId);
    }
}
