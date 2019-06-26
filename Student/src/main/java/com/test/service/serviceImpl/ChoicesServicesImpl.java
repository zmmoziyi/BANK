package com.test.service.serviceImpl;

import com.test.dao.ChoicesMapper;
import com.test.entity.Choices;
import com.test.entity.Judgments;
import com.test.entity.Teachers;
import com.test.service.ChoiceService;
import com.test.vo.ChoiceVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author 张敏
 * @Title: ChoicesServicesImpl
 * @ProjectName Student
 * @Description: TODO
 * @date 2019/2/1512:00
 */
@Service
public class ChoicesServicesImpl implements ChoiceService {
    @Autowired
    ChoicesMapper choicesMapper;
    //ChoiceVo choiceVo;
    @Override
    public List<Choices> crateChoice(Double choice_difficulty) {
        return choicesMapper.selectByDifficulty(choice_difficulty);
    }

    @Override
    public List<ChoiceVo> selectAllChoice(String point,int before, int after) {

        List<Choices> choices=choicesMapper.selectAllChoice(point,before,after);

        List <ChoiceVo> list=new ArrayList<ChoiceVo>();
        for(int i = 0;i < choices.size();i++){
            ChoiceVo choiceVo=new ChoiceVo();
           choiceVo.setChoice_id(choices.get(i).getChoice_id());
           choiceVo.setChoice_content(choices.get(i).getChoice_content());
           choiceVo.setChoice_first(choices.get(i).getChoice_first());
           choiceVo.setChoice_second(choices.get(i).getChoice_second());
           choiceVo.setChoice_third(choices.get(i).getChoice_third());
           choiceVo.setChoice_fourth(choices.get(i).getChoice_fourth());
           choiceVo.setChoice_answer(choices.get(i).getChoice_answer());
           choiceVo.setChoice_difficulty(choices.get(i).getChoice_difficulty());
           choiceVo.setPoint(choices.get(i).getPoint());
           choiceVo.setChoice_time(choices.get(i).getChoice_time());
           choiceVo.setTeacher_name(choices.get(i).getTeachers().getTeacher_name());
            list.add(choiceVo);
        }
        return list;
    }

    @Override
    public int count() {
        return choicesMapper.count();
    }

    @Override
    public Choices selectByPrimaryKey(int choice_id) {
        return choicesMapper.selectByPrimaryKey(choice_id);
    }

    @Override
    public List<Choices> paper(String point) {
        return choicesMapper.selectByPoint(point);
    }


    @Override
    public int addChoice(Choices choices) {
        return choicesMapper.insertSelective(choices);
    }

    @Override
    public int updateChoice(Choices choices) {
        return choicesMapper.updateByPrimaryKeySelective(choices);
    }

    @Override
    public int deleteChoice(int choice_id) {
        return choicesMapper.deleteByPrimaryKey(choice_id);
    }
}
