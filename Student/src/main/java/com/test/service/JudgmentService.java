package com.test.service;

import com.test.entity.Discussions;
import com.test.entity.Judgments;
import com.test.vo.DiscussionVo;
import com.test.vo.JudgmentVo;
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
public interface JudgmentService {
    /**
     * 根据难度选择试题
     * @param
     * @return
     */
    public List<Judgments> crateChoice(Double judgment_difficulty);

    /**
     * 根据主键选择试题
     * @param
     * @return
     */
    public Judgments selectByPrimaryKey(int judgment_id);

    /**
     * 根据知识点选择试题
     * @param
     * @return
     */
    public List<Judgments> paper(String point);


    /**
     * 添加试题
     * @param
     * @return
     */

    public int addJudgments(Judgments judgments);

    /**
     * 修改试题
     * @param
     * @return
     */

    public int updateJudgments(Judgments judgments);

    /**
     * 删除试题
     * @param
     * @return
     */

    public int deleteJudgments(int judgment_id);

    /**
     * 加载所有选择题
     * @return
     */
    public List<JudgmentVo> selectAll(String point,int before, int after);

    /**
     * 计算试题总数
     * @return
     */

    public int count();
}
