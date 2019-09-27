package com.hql.dao;

import com.hql.entity.Student;

public interface StudentMapper {
    int insert(Student record);

    int insertSelective(Student record);
}