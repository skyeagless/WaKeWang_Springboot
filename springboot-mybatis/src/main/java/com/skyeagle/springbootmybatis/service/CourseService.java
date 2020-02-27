package com.skyeagle.springbootmybatis.service;

import com.skyeagle.springbootmybatis.entity.Course;

public interface CourseService {
    public Course getCourseById(int id);
    public int updateCourse(Course course);
}
