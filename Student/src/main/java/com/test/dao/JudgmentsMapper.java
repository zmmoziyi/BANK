package com.test.dao;

import com.test.entity.Discussions;
import com.test.entity.Judgments;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface JudgmentsMapper {
    List<Judgments> selectAll(@Param("point")String point,@Param("before") Integer before, @Param("after") Integer after);

    int count();
    int deleteByPrimaryKey(Integer judgment_id);

    int insert(Judgments record);

    int insertSelective(Judgments record);

    Judgments selectByPrimaryKey(Integer judgment_id);

    int updateByPrimaryKeySelective(Judgments record);

    int updateByPrimaryKey(Judgments record);

    List<Judgments> selectByPoint(String point);
}