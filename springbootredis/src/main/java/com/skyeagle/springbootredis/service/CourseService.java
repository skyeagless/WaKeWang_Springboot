package com.skyeagle.springbootredis.service;


import com.skyeagle.springbootredis.entity.Course;



public interface CourseService {
    public Course getCourseById(int id);
    public int updateCourse(Course course);
}
