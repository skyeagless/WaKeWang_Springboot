package com.wkcto.springboot.service.impl;

import com.wkcto.springboot.mapper.StudentMapper;
import com.wkcto.springboot.model.Student;
import com.wkcto.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ClassName:StudentServiceImpl
 * <p>
 * Package:com.wkcto.springboot.service.impl
 * Description:
 *
 * @Date:2018/8/7 12:21
 * @Author:蛙课网
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student getStudentById(Integer id) {
        return studentMapper.selectByPrimaryKey(id);
    }

    @Transactional //对该方法进行事务管理，如果该方法抛出异常，事务就会回滚
    @Override
    public int updateStudent(Student student) {

        int update = studentMapper.updateByPrimaryKeySelective(student);

        int a = 10 / 0; //0不能作为除数，会抛出运行时异常

        return update;
    }
}