package com.test.dao;

import com.test.entity.Definitions;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DefinitionsMapper {
    List<Definitions> selectAll(@Param("point")String point,@Param("before") Integer before, @Param("after") Integer after);

    int count();

    int deleteByPrimaryKey(Integer definition_id);

    int insert(Definitions record);

    int insertSelective(Definitions record);

    Definitions selectByPrimaryKey(Integer definition_id);

    int updateByPrimaryKeySelective(Definitions record);

    int updateByPrimaryKey(Definitions record);

    List<Definitions> selectByPoint(String point);
}