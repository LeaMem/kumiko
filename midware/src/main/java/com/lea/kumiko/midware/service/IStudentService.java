package com.lea.kumiko.midware.service;

import com.lea.kumiko.midware.entity.Student;

import java.util.List;

public interface IStudentService {

    List<Student> listAll();

    long insert(String name, Integer age);

}
