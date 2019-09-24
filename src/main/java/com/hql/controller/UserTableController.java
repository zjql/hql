package com.hql.controller;

import com.hql.config.Result;
import com.hql.entity.UserTable;
import com.hql.service.UserTableService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

import java.util.List;
import java.util.Objects;


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

    @RequestMapping("/login")
    public Result login(@RequestBody UserTable userTable){

        // 对 html 标签进行转义，防止 XSS 攻击
        String username = userTable.getName();
        username = HtmlUtils.htmlEscape(username);
        if (!Objects.equals("admin", username) || !Objects.equals("123456", userTable.getPassword())) {
            String message = "账号密码错误";
            System.out.println("test");
            return new Result(400);
        } else {
            return new Result(200);
        }
    }
}
