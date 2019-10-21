package com.hql.controller;

import com.hql.utils.R;
import com.hql.entity.UserTable;
import com.hql.service.UserTableService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import java.util.List;
import java.util.Objects;


/**
 * @author 开发者中文姓名
 * @date 2019/9/23 17:07
 */
@RestController
@RequestMapping()
@Api(value = "用户测试模块")
public class UserTableController {

    private static Logger logger = LogManager.getLogger(UserTableController.class);

    @Autowired
    private UserTableService userTableService;

    @ApiOperation(value = "添加用户",notes = "根据参数添加用户")
    @PostMapping(value = "/getUser")
    public Object getUser(){
        return new UserTable(123,"张晨","123123");
    }

    @RequestMapping("/query/{userId}")
    public List<UserTable> queryUserTable(@PathVariable Integer userId){
        logger.info(userId);
//        return userId;
        return userTableService.queryAllUserTableId(userId);
    }

    @PostMapping("/login")
    public R login(@RequestBody UserTable userTable){
        String username = userTable.getName();
        String password = userTable.getPassword();
        if("".equals(username)){
            return R.error("用户名不能为空");
        }
        if("".equals(password)){
            return R.error("密码不能为空");
        }
        username = HtmlUtils.htmlEscape(username);
        if (!Objects.equals("admin", username) || !Objects.equals("123456", userTable.getPassword())) {
            return R.error(400,"用户名或密码错误");
        } else {
            return R.ok();
        }
    }
}
