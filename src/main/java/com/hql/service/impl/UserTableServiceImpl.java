package com.hql.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hql.dao.UserTableMapper;
import com.hql.entity.UserTable;
import com.hql.service.UserTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 开发者中文姓名
 * @date 2019/9/23 16:58
 */
@Service("userTableService")
public class UserTableServiceImpl extends ServiceImpl<UserTableMapper,UserTable> implements UserTableService {

    @Autowired
    private UserTableMapper userTableMapper;
    @Override
    public List<UserTable> queryAllUserTableId(int userId) {
        return userTableMapper.queryAllUserTableId(userId);
    }
}
