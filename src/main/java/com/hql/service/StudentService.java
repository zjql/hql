package com.hql.service;

import com.baomidou.mybatisplus.service.IService;
import com.hql.entity.Student;

import java.util.List;

/**
 * @author 开发者中文姓名
 * @date 2019/9/28 0:35
 */
public interface StudentService extends IService<Student> {

    List<Student> queryStudentId(int id);
}
