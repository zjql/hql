package com.hql.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.hql.entity.UserTable;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserTableMapper extends BaseMapper<UserTable> {

    @Override
    Integer insert(UserTable record);

    int insertSelective(UserTable record);

    List<UserTable> queryAllUserTableId(int id);
}