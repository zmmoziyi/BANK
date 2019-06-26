package com.test.dao;

import com.test.entity.Completions;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CompletionsMapper {
    int deleteByPrimaryKey(Integer completion_id);

    int insert(Completions record);

    int insertSelective(Completions record);

    Completions selectByPrimaryKey(Integer completion_id);

    List<Completions> selectAll(@Param("point")String point,@Param("before") Integer before, @Param("after") Integer after);

    List<Completions> selectByDifficulty(Double completion_difficulty);

    int count();

    int updateByPrimaryKeySelective(Completions record);

    int updateByPrimaryKey(Completions record);

    List<Completions> selectByPoint(String point);

}