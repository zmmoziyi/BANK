package com.test.service.serviceImpl;

import com.test.dao.CompletionsMapper;
import com.test.dao.DefinitionsMapper;
import com.test.entity.Completions;
import com.test.entity.Definitions;
import com.test.service.CompletionService;
import com.test.service.DefinitionService;
import com.test.vo.CompletionVo;
import com.test.vo.DefinitionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 张敏
 * @Title: ChoicesServicesImpl
 * @ProjectName Student
 * @Description: TODO
 * @date 2019/2/1512:00
 */
@Service
public class DefinitionServicesImpl implements DefinitionService {
    @Autowired
    DefinitionsMapper definitionsMapper;
    //ChoiceVo choiceVo;
    @Override
    public List<Definitions> paper(String point) {
        return definitionsMapper.selectByPoint(point);
    }

    @Override
    public List<Definitions> crateChoice(Double definition_difficulty) {
        return null;
    }

    @Override
    public Definitions selectByPrimaryKey(int definition_id) {
        return null;
    }

    @Override
    public int addDefinition(Definitions definitions) {
        return definitionsMapper.insertSelective(definitions);
    }

    @Override
    public int updateDefinition(Definitions definitions) {
        return definitionsMapper.updateByPrimaryKeySelective(definitions);
    }

    @Override
    public int deleteDefinition(int definition_id) {
        return definitionsMapper.deleteByPrimaryKey(definition_id);
    }

    @Override
    public List<DefinitionVo> selectAll(String point,int before, int after) {
        List<Definitions> definitions=definitionsMapper.selectAll(point,before,after);

        List <DefinitionVo> list=new ArrayList<DefinitionVo>();
        for(int i = 0;i <definitions .size();i++){
            DefinitionVo definitionVo=new DefinitionVo();
            definitionVo.setDefinition_id(definitions.get(i).getDefinition_id());
            definitionVo.setDefinition_content(definitions.get(i).getDefinition_content());

            definitionVo.setDefinition_answer(definitions.get(i).getDefinition_answer());
            definitionVo.setDefinition_difficulty(definitions.get(i).getDefinition_difficulty());
            definitionVo.setPoint(definitions.get(i).getPoint());
            definitionVo.setChoice_time(definitions.get(i).getChoice_time());
            definitionVo.setTeacher_name(definitions.get(i).getTeachers().getTeacher_name());
            list.add(definitionVo);
        }
        return list;
    }

    @Override
    public int count() {
        return definitionsMapper.count();
    }
}
