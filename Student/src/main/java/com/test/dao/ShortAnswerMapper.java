package com.test.dao;

import com.test.entity.ShortAnswer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShortAnswerMapper {
    List<ShortAnswer> selectAll(@Param("point")String point,@Param("before") Integer before, @Param("after") Integer after);

    int count();
    int deleteByPrimaryKey(Integer shortAnswer_id);

    int insert(ShortAnswer record);

    int insertSelective(ShortAnswer record);

    ShortAnswer selectByPrimaryKey(Integer shortAnswer_id);

    int updateByPrimaryKeySelective(ShortAnswer record);

    int updateByPrimaryKey(ShortAnswer record);

    List<ShortAnswer> selectByPoint(String point);
}