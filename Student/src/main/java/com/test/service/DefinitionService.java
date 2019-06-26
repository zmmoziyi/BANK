package com.test.service;

import com.test.entity.Choices;
import com.test.entity.Definitions;
import com.test.vo.ChoiceVo;
import com.test.vo.DefinitionVo;
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
public interface DefinitionService {
    /**
     * 根据难度选择试题
     * @param definition_difficulty
     * @return
     */
    public List<Definitions> crateChoice(Double definition_difficulty);

    /**
     * 根据主键选择试题
     * @param definition_id
     * @return
     */
    public Definitions selectByPrimaryKey(int definition_id);

    /**
     * 根据知识点选择试题
     * @param
     * @return
     */
    public List<Definitions> paper(String point);


    /**
     * 添加试题
     * @param definitions
     * @return
     */

    public int addDefinition(Definitions definitions);

    /**
     * 修改试题
     * @param
     * @return
     */

    public int updateDefinition(Definitions definitions);

    /**
     * 删除试题
     * @param
     * @return
     */

    public int deleteDefinition(int definition_id);

    /**
     * 加载所有选择题
     * @return
     */
    public List<DefinitionVo> selectAll(String point,int before, int after);

    /**
     * 计算试题总数
     * @return
     */

    public int count();
}
