package com.test.service;

import com.test.entity.Choices;
import com.test.entity.Student;
import com.test.entity.Teachers;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @author 张敏
 * @Title: StudentService
 * @ProjectName Student
 * @Description: TODO
 * @date 2019/4/2518:44
 */
@Service
public interface StudentService {
    /**
     * 登录
     * @param student_id
     * @param student_password
     * @return
     */
    public HashMap login(String student_id, String student_password);

    /**
     * 修改密码
     * @param student_id
     * @param student_password
     * @return
     */
    public int changeuser(String student_id, String student_password);

    public Student selectStudent(String student_id);

    public int deleteChoice(String student_id);

    /**
     * 加载所有选择题
     * @return
     */
    public List<Student> selectAll(Integer before, Integer after);

    /**
     * 计算总数
     * @return
     */

    public int count();

    /**
     * 更新
     * @param student
     * @return
     */

    public int updateStudent(Student student);
    /**
     * 添加学生
     * @param student
     * @return
     */
    public int adduser(Student student);

}
