package com.test.service;

import com.test.entity.Definitions;
import com.test.entity.ShortAnswer;
import com.test.vo.DefinitionVo;
import com.test.vo.ShortAnswerVo;
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
public interface ShortAnswerService {
    /**
     * 根据难度选择试题
     * @param
     * @return
     */
    public List<ShortAnswer> crateChoice(Double shortAnswer_difficulty);

    /**
     * 根据主键选择试题
     * @param
     * @return
     */
    public ShortAnswer selectByPrimaryKey(int shortAnswer_id);

    /**
     * 根据知识点选择试题
     * @param
     * @return
     */
    public List<ShortAnswer> paper(String point);


    /**
     * 添加试题
     * @param
     * @return
     */

    public int addShortAnswer(ShortAnswer shortAnswer);

    /**
     * 修改试题
     * @param
     * @return
     */

    public int updateShortAnswer(ShortAnswer shortAnswer);

    /**
     * 删除试题
     * @param
     * @return
     */

    public int deleteShortAnswer(int shortAnswer_id);

    /**
     * 加载所有选择题
     * @return
     */
    public List<ShortAnswerVo> selectAll(String point,int before, int after);

    /**
     * 计算试题总数
     * @return
     */

    public int count();
}
