package com.skyeagle.springbootmybatis.service.impl;

import com.skyeagle.springbootmybatis.dao.CourseMapper;
import com.skyeagle.springbootmybatis.entity.Course;
import com.skyeagle.springbootmybatis.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public Course getCourseById(int id) {
        return courseMapper.selectByPrimaryKey(id);
    }
    //该方法进行事务管理，异常就会回滚
    @Transactional
    @Override
    public int updateCourse(Course course) {
        return courseMapper.updateByPrimaryKey(course);
    }
}
