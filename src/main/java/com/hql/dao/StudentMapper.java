package com.hql.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.hql.entity.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper extends BaseMapper<Student> {
    @Override
    Integer insert(Student record);

    int insertSelective(Student record);

    List<Student> queryStudentId(int id);
}