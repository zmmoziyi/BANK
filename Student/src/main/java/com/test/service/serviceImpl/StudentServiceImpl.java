package com.test.service.serviceImpl;

import com.test.dao.StudentMapper;
import com.test.dao.TeachersMapper;
import com.test.entity.Choices;
import com.test.entity.Student;
import com.test.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @author 张敏
 * @Title: StudentServiceImpl
 * @ProjectName Student
 * @Description: TODO
 * @date 2019/4/2518:45
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentMapper studentMapper;
    @Override
    public HashMap login(String student_id, String student_password) {
        Student student=studentMapper.login(student_id,student_password);

        HashMap result = new HashMap();
        if(student != null){
            result.put("admin",student);
            result.put("isSuccess","true");
        }else{
            result.put("isSuccess","false");
        }
        return result;
    }

    @Override
    public int changeuser(String student_id, String student_password) {
        return studentMapper.updateByPassword(student_id,student_password);
    }

    @Override
    public Student selectStudent(String student_id) {
        return studentMapper.selectByPrimaryKey(student_id);
    }

    @Override
    public int deleteChoice(String student_id) {
        return studentMapper.deleteByPrimaryKey(student_id);
    }



    @Override
    public List<Student> selectAll(Integer before, Integer after) {
        return studentMapper.selectAll(before,after);
    }

    @Override
    public int count() {
        return studentMapper.count();
    }

    @Override
    public int updateStudent(Student student) {
        return studentMapper.updateByPrimaryKeySelective(student);
    }

    @Override
    public int adduser(Student student) {
        return studentMapper.insertSelective(student);
    }
}
