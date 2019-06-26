package com.test.service.serviceImpl;

import com.test.dao.TeachersMapper;
import com.test.entity.Choices;
import com.test.entity.Teachers;
import com.test.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

/**
 * @Title: StudentServiceImpl
 * @ProjectName SSM_student
 * @Description: TODO
 * @author 张敏
 * @date 2019/1/1514:54
 */
@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    TeachersMapper teachersMapper;

    @Override
    public HashMap login(String teacher_id,String teacher_password){
        Teachers teachers=teachersMapper.login(teacher_id,teacher_password);
        HashMap result = new HashMap();
        if(teachers != null){
            result.put("admin",teachers);
            result.put("isSuccess","true");
        }else{
            result.put("isSuccess","false");
        }
        return result;
    }

    @Override
    public Teachers selectTeacher(String teacher_id) {
        return teachersMapper.selectByPrimaryKey(teacher_id);
    }

    @Override
    public int deleteuser(String teacher_id) {

        return teachersMapper.deleteByPrimaryKey(teacher_id);
    }

    @Override
    public int adduser(Teachers teachers) {
        return teachersMapper.insertSelective(teachers);
    }

    @Override
    public int changeuser(String teacher_password,String teacher_id) {
        return teachersMapper.updateByPassword(teacher_password,teacher_id);
    }

    @Override
    public int deleteteacher(String teacher_id) {
        return teachersMapper.deleteByPrimaryKey(teacher_id);
    }

    @Override
    public List<Teachers> selectAll(int before, int after) {
        return teachersMapper.selectAll(before,after);
    }

    @Override
    public int count() {
        return teachersMapper.count();
    }

    @Override
    public int updateTeacher(Teachers teachers) {
        return teachersMapper.updateByPrimaryKeySelective(teachers);
    }


}
