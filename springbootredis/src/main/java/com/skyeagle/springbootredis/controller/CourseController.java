package com.skyeagle.springbootredis.controller;


import com.skyeagle.springbootredis.entity.Course;
import com.skyeagle.springbootredis.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;

    @RequestMapping("/course")
    public Object course(){
        //创建一个线程池
        ExecutorService executorService = Executors.newFixedThreadPool(8);
        for(int i=0;i<200000;i++){
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    courseService.getCourseById(1);
                }
            });
        }
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
