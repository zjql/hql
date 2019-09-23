package com.hql.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hql.entity.UserTable;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserTableMapper extends BaseMapper<UserTable> {
    int insert(UserTable record);

    int insertSelective(UserTable record);

    List<UserTable> queryAllUserTableId(int id);
}