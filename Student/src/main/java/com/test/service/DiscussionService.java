package com.test.service;

import com.test.entity.Definitions;
import com.test.entity.Discussions;
import com.test.vo.DefinitionVo;
import com.test.vo.DiscussionVo;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author 张敏
 * @Title: ChioceService
 * @ProjectName Student
 * @Description: TODO
 * @date 2019/2/1511:45
 */
@Service
public interface DiscussionService {
    /**
     * 根据难度选择试题
     * @param
     * @return
     */
    public List<Discussions> crateChoice(Double discussion_difficulty);

    /**
     * 根据主键选择试题
     * @param
     * @return
     */
    public Discussions selectByPrimaryKey(int discussion_id);

    /**
     * 根据知识点选择试题
     * @param
     * @return
     */
    public List<Discussions> paper(String point);



    /**
     * 添加试题
     * @param
     * @return
     */

    public int addDiscussions( Discussions discussions);

    /**
     * 修改试题
     * @param
     * @return
     */

    public int updateDiscussions(Discussions discussions);

    /**
     * 删除试题
     * @param
     * @return
     */

    public int deleteDiscussion(int discussion_id);

    /**
     * 加载所有选择题
     * @return
     */
    public List<DiscussionVo> selectAll(String point,int before, int after);

    /**
     * 计算试题总数
     * @return
     */

    public int count();
}
