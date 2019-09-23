package com.hql.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hql.entity.UserTable;

import java.util.List;

/**
 * @author 开发者中文姓名
 * @date 2019/9/23 16:58
 */
public interface UserTableService extends IService<UserTable> {
    List<UserTable> queryAllUserTableId(int userId);
}
