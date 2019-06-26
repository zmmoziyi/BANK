package com.test.dao;

import com.test.entity.Papers;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PapersMapper {
    int deleteByPrimaryKey(Integer paper_id);

    int insert(Papers record);

    int insertSelective(Papers record);

    Papers selectByPrimaryKey(Integer paper_id);

    List<Papers> selectAllpaper(@Param("before") Integer before, @Param("after") Integer after);

    int count();

    int updateByPrimaryKeySelective(Papers record);

    int updateByPrimaryKey(Papers record);
}