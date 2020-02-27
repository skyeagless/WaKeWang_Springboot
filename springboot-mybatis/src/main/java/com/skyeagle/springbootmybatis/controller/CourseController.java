package com.skyeagle.springbootmybatis.controller;

import com.skyeagle.springbootmybatis.entity.Course;
import com.skyeagle.springbootmybatis.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;

    @RequestMapping("/course")
    public Object course(){
        return courseService.getCourseById(1);
    }

    @RequestMapping("/update")
    public Object updateCourse(){
        Course course = new Course();
        course.setId(1);
        course.setName("语文");
        course.setScore(4);
        return courseService.updateCourse(course);
    }

}
