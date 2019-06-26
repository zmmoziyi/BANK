package com.test.service;

import com.test.entity.Choices;
import com.test.entity.Completions;
import com.test.vo.ChoiceVo;
import com.test.vo.CompletionVo;
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
public interface CompletionService {
    /**
     * 根据难度选择试题
     * @param completion_difficulty
     * @return
     */
    public List<Completions> cratecompletion(double completion_difficulty);

    /**
     * 根据主键选择试题
     * @param completion_id
     * @return
     */
    public Completions selectByPrimaryKey(int completion_id);

    /**
     * 根据知识点选择试题
     * @param
     * @return
     */
    public List<Completions > paper(String point);

    /**
     * 添加试题
     * @param
     * @return
     */

    public int addCompletion(Completions completions);

    /**
     * 修改试题
     * @param
     * @return
     */

    public int updateCompletion(Completions completions);

    /**
     * 删除试题
     * @param
     * @return
     */

    public int deleteCompletion(int  completion_id);

    /**
     * 加载所有选择题
     * @return
     */
    public List<CompletionVo> selectAllChoice(String point,int before, int after);

    /**
     * 计算试题总数
     * @return
     */

    public int count();
}
