package com.test.service;

import com.test.entity.Choices;
import com.test.vo.ChoiceVo;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;


/**
 * @author 张敏
 * @Title: ChioceService
 * @ProjectName Student
 * @Description: TODO
 * @date 2019/2/1511:45
 */
@Service
public interface ChoiceService {
    /**
     * 根据难度选择试题
     * @param choice_difficulty
     * @return
     */
    public List<Choices> crateChoice(Double choice_difficulty);

    /**
     * 根据主键选择试题
     * @param choice_id
     * @return
     */
    public Choices selectByPrimaryKey(int choice_id);

    /**
     * 根据知识点选择试题
     * @param
     * @return
     */
    public List<Choices> paper(String point);

    /**
     * 添加试题
     * @param choices
     * @return
     */

    public int addChoice(Choices choices);

    /**
     * 修改试题
     * @param choices
     * @return
     */

    public int updateChoice(Choices choices);

    /**
     * 删除试题
     * @param choice_id
     * @return
     */

    public int deleteChoice(int choice_id);

    /**
     * 加载所有选择题
     * @return
     */
    public List<ChoiceVo> selectAllChoice(String point,int before, int after);

    /**
     * 计算试题总数
     * @return
     */

    public int count();
}
