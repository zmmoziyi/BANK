package com.test.service.serviceImpl;

import com.test.dao.DiscussionsMapper;
import com.test.dao.ShortAnswerMapper;
import com.test.entity.Discussions;
import com.test.entity.ShortAnswer;
import com.test.service.DiscussionService;
import com.test.service.ShortAnswerService;
import com.test.vo.DiscussionVo;
import com.test.vo.ShortAnswerVo;
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
public class ShortAnswerServicesImpl implements ShortAnswerService {
    @Autowired
    ShortAnswerMapper shortAnswerMapper;
    //ChoiceVo choiceVo;


    @Override
    public List<ShortAnswer> crateChoice(Double shortAnswer_difficulty) {
        return null;
    }

    @Override
    public ShortAnswer selectByPrimaryKey(int shortAnswer_id) {
        return shortAnswerMapper.selectByPrimaryKey(shortAnswer_id);
    }

    @Override
    public List<ShortAnswer> paper(String point) {
        return shortAnswerMapper.selectByPoint(point);
    }

    @Override
    public int addShortAnswer(ShortAnswer shortAnswer) {
        return shortAnswerMapper.insertSelective(shortAnswer);
    }

    @Override
    public int updateShortAnswer(ShortAnswer shortAnswer) {
        return shortAnswerMapper.updateByPrimaryKeySelective(shortAnswer);
    }

    @Override
    public int deleteShortAnswer(int shortAnswer_id) {
        return shortAnswerMapper.deleteByPrimaryKey(shortAnswer_id);
    }


    @Override
    public List<ShortAnswerVo> selectAll(String point,int before, int after) {
        List<ShortAnswer> shortAnswers=shortAnswerMapper.selectAll(point,before,after);

        List <ShortAnswerVo> list=new ArrayList<ShortAnswerVo>();
        for(int i = 0;i <shortAnswers .size();i++){
            ShortAnswerVo shortAnswerVo=new ShortAnswerVo();
            shortAnswerVo.setSa_id(shortAnswers.get(i).getShortAnswer_id());
            shortAnswerVo.setSa_content(shortAnswers.get(i).getShortAnswer_content());

            shortAnswerVo.setSa_answer(shortAnswers.get(i).getShortAnswer_answer());
            shortAnswerVo.setSa_difficulty(shortAnswers.get(i).getShortAnswer_difficulty());
            shortAnswerVo.setPoint(shortAnswers.get(i).getPoint());
            shortAnswerVo.setChoice_time(shortAnswers.get(i).getChoice_time());
            shortAnswerVo.setTeacher_name(shortAnswers.get(i).getTeachers().getTeacher_name());
            list.add(shortAnswerVo);
        }
        return list;
    }

    @Override
    public int count() {
        return shortAnswerMapper.count();
    }
}
