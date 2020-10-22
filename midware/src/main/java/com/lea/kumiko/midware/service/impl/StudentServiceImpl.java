package com.lea.kumiko.midware.service.impl;

import com.lea.kumiko.midware.entity.Student;
import com.lea.kumiko.midware.mapper.StudentMapper;
import com.lea.kumiko.midware.service.AbstractService;
import com.lea.kumiko.midware.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;

@Service
public class StudentServiceImpl extends AbstractService<Student> implements IStudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> listAll() {
        return studentMapper.selectAll();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @Retryable()
    public long insert(String name, Integer age) {
        Student student = new Student();
        student.setAge(age);
        student.setName(name);
        studentMapper.insertSelective(student);
        Integer.valueOf("sdf");
        return student.getId();
    }

    public static void main(String[] args) {
        StudentServiceImpl studentService = new StudentServiceImpl();
        Condition conditionV2 = studentService.getConditionV2();
    }
}
