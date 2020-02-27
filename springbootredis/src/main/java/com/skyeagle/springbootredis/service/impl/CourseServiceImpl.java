package com.skyeagle.springbootredis.service.impl;


import com.skyeagle.springbootredis.dao.CourseMapper;
import com.skyeagle.springbootredis.entity.Course;
import com.skyeagle.springbootredis.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    //springboot自动初始化，不需要配置，直接可以注入到代码中
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    @Override
    public Course getCourseById(int id) {

        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //查询缓存
        Course course = (Course) redisTemplate.opsForValue().get("courseKey");

        //判断缓存是否为空
        if (course == null) {
            //双重检测锁
            synchronized (this) {
                //检查缓存
                course = (Course) redisTemplate.opsForValue().get("courseKey");
                if (course == null) {
                    //查询数据库
                    System.out.println("查询数据库");
                    course = courseMapper.selectByPrimaryKey(id);
                    //放入缓存
                    redisTemplate.opsForValue().set("courseKey", course);
                }
            }
        } else {
            System.out.println("查询了缓存");
        }
        return course;
    }

    //该方法进行事务管理，异常就会回滚
    @Transactional
    @Override
    public int updateCourse(Course course) {
        return courseMapper.updateByPrimaryKey(course);
    }
}
