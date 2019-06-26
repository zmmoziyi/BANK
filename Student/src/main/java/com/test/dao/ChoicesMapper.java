package com.test.dao;

import com.test.entity.Choices;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChoicesMapper {
    int deleteByPrimaryKey(Integer choice_id);

    int insert(Choices record);

    int insertSelective(Choices record);

    Choices selectByPrimaryKey(Integer choice_id);

    List<Choices> selectByDifficulty(Double choice_difficulty);

    List<Choices> selectAllChoice(@Param("point")String point,@Param("before") Integer before, @Param("after") Integer after);


    int count();

    int updateByPrimaryKeySelective(Choices record);

    int updateByPrimaryKey(Choices record);

    List<Choices> selectByPoint(String point);

    List<Choices> selectById(int id);
}