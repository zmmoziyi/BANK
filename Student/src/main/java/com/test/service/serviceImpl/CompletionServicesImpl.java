package com.test.service.serviceImpl;

import com.test.dao.ChoicesMapper;
import com.test.dao.CompletionsMapper;
import com.test.entity.Choices;
import com.test.entity.Completions;
import com.test.service.ChoiceService;
import com.test.service.CompletionService;
import com.test.vo.ChoiceVo;
import com.test.vo.CompletionVo;
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
public class CompletionServicesImpl implements CompletionService {
    @Autowired
    CompletionsMapper completionsMapper;
    //ChoiceVo choiceVo;

    @Override
    public List<CompletionVo> selectAllChoice(String point ,int before, int after) {

        List<Completions> completions=completionsMapper.selectAll(point,before,after);
        System.out.println(completionsMapper.selectAll(point,before,after));
        List <CompletionVo> list=new ArrayList<CompletionVo>();
        for(int i = 0;i <completions .size();i++){
            CompletionVo completionVo=new CompletionVo();
            completionVo.setCompletion_id(completions.get(i).getCompletion_id());
            completionVo.setCompletion_content(completions.get(i).getCompletion_content());

            completionVo.setCompletion_answer(completions.get(i).getCompletion_answer());
            completionVo.setCompletion_difficulty(completions.get(i).getCompletion_difficulty());
            completionVo.setPoint(completions.get(i).getPoint());
            completionVo.setChoice_time(completions.get(i).getChoice_time());
            completionVo.setTeacher_name(completions.get(i).getTeachers().getTeacher_name());
            list.add(completionVo);
        }
        return list;
    }


    @Override
    public List<Completions> cratecompletion(double completion_difficulty) {
        return completionsMapper.selectByDifficulty(completion_difficulty);
    }

    @Override
    public Completions selectByPrimaryKey(int completion_id) {
        return completionsMapper.selectByPrimaryKey(completion_id);
    }

    @Override
    public List<Completions> paper(String point) {
        return completionsMapper.selectByPoint(point);
    }

    @Override
    public int addCompletion(Completions completions) {
        return completionsMapper.insertSelective(completions);
    }

    @Override
    public int updateCompletion(Completions completions) {
        return completionsMapper.updateByPrimaryKeySelective(completions);
    }

    @Override
    public int deleteCompletion(int completion_id) {
        return completionsMapper.deleteByPrimaryKey(completion_id);
    }

    @Override
    public int count() {
        return completionsMapper.count();
    }
}
