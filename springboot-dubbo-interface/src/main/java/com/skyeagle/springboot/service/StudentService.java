package com.skyeagle.springboot.service;

import com.skyeagle.springboot.model.Student;

public interface StudentService {
    public Student getStudentById(Integer id);
    public int updateStudent(Student student);
}
