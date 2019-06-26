package com.test.dao;

import com.test.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {
    int deleteByPrimaryKey(String student_id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(String student_id);

    Student  login(@Param("student_id") String student_id, @Param("student_password") String student_password);

    List<Student> selectAll(@Param("before") Integer before, @Param("after") Integer after);

    int updateByPassword( @Param("student_password") String student_password,@Param("student_id") String student_id);

    int count();


    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}