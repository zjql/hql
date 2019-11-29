package com.hql.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hql.dao.StudentMapper;
import com.hql.entity.Student;
import com.hql.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 开发者中文姓名
 * @date 2019/9/28 0:37
 */
@Service("studentService")
public  class StudentServiceImpl extends ServiceImpl<StudentMapper,Student> implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> queryStudentId(int id) {
        return studentMapper.queryStudentId(id);
    }

    @Override
    public List<Student> queryStudnetIdCall(int id) {
        return studentMapper.queryStudentIdCall(id);
    }
}
