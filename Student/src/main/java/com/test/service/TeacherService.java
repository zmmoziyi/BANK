package com.test.service;

import com.test.entity.Choices;
import com.test.entity.Teachers;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

/**
 * @author 张敏
 * @Title: StudentService
 * @ProjectName SSM_student
 * @Description: TODO
 * @date 2019/1/1514:44
 */
@Service
public interface TeacherService {
    /**
     * 登录
     * @param teacher_id
     * @param teacher_password
     * @return
     */
    public HashMap login(String teacher_id,String teacher_password);

    /**
     * 根据Id查出教师
     * @param teacher_id
     * @return
     */

    public Teachers selectTeacher(String teacher_id);

    /**
     * 删除教师
     * @param teacher_id
     * @return
     */
    public int deleteuser(String teacher_id);

    /**
     * 添加教师
     * @param teachers
     * @return
     */
    public int adduser(Teachers teachers);

    /**
     * 修改密码
     * @param teacher_password
     * @param teacher_id
     * @return
     */
    public int changeuser(String teacher_password,String teacher_id);

    /**
     * 根据id删除
     * @param teacher_id
     * @return
     */

    public int deleteteacher(String teacher_id);

    /**
     * 加载所有选择题
     * @return
     */
    public List<Teachers> selectAll(int before, int after);

    /**
     * 计算试题总数
     * @return
     */

    public int count();
    /**
     * 更新
     * @param teachers
     * @return
     */

    public int updateTeacher(Teachers teachers);
}
