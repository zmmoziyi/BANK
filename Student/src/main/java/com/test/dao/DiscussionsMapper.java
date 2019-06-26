package com.test.dao;

import com.test.entity.Discussions;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DiscussionsMapper {
    List<Discussions> selectAll(@Param("point")String point,@Param("before") Integer before, @Param("after") Integer after);

    int count();
    int deleteByPrimaryKey(Integer discussion_id);

    int insert(Discussions record);

    int insertSelective(Discussions record);

    Discussions selectByPrimaryKey(Integer discussion_id);

    int updateByPrimaryKeySelective(Discussions record);

    int updateByPrimaryKey(Discussions record);

    List<Discussions> selectByPoint(String point);
}