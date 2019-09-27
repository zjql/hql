package com.hql.controller;

import com.hql.entity.Student;
import com.hql.service.StudentService;
import com.hql.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 开发者中文姓名
 * @date 2019/9/28 0:53
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

   @RequestMapping(value = "/query",method = RequestMethod.POST)
    public R queryStudentId(@RequestParam Integer id){
       List<Student> list =  studentService.queryStudentId(id);
       return R.ok().put("list",list);
    }
}
