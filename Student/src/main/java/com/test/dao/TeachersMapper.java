package com.test.dao;

import com.test.entity.Teachers;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeachersMapper {
    int deleteByPrimaryKey(String teacher_id);

    int insert(Teachers record);

    int insertSelective(Teachers record);

    Teachers selectByPrimaryKey(String teacher_id);

    Teachers login(@Param("teacher_id") String teacher_id, @Param("teacher_password") String teacher_password);

    List<Teachers> selectAll(@Param("before") Integer before, @Param("after") Integer after);

    int count();

    int updateByPrimaryKeySelective(Teachers record);

    int updateByPrimaryKey(Teachers record);

    int updateByPassword(@Param("teacher_password") String teacher_password,@Param("teacher_id")String teacher_id);
}