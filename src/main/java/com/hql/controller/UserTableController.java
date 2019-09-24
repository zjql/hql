package com.hql.controller;

import com.hql.entity.UserTable;
import com.hql.service.UserTableService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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

    private static Logger logger = LogManager.getLogger(UserTableController.class);

    @Autowired
    private UserTableService userTableService;

    @RequestMapping("/query/{userId}")
    public List<UserTable> queryUserTable(@PathVariable Integer userId){
        logger.info(userId);
//        return userId;
        return userTableService.queryAllUserTableId(userId);
    }
}
