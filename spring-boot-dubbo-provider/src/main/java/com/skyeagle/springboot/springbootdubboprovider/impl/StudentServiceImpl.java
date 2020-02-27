package com.skyeagle.springboot.springbootdubboprovider.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.skyeagle.springboot.model.Student;
import com.skyeagle.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Service(timeout = 10000, retries = 1)
public class StudentServiceImpl implements StudentService{

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
