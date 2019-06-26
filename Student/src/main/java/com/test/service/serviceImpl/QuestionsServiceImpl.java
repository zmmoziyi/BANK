
package com.test.service.serviceImpl;

import com.test.dao.ChoicesMapper;
import com.test.dao.CompletionsMapper;
import com.test.entity.Choices;
import com.test.entity.Completions;
import com.test.service.QuestionsService;
import com.test.util.TrUtil;
import com.test.vo.QuestionVo;
import com.test.vo.RuleVO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author 张敏
 * @Title: QuestionsServiceImpl
 * @ProjectName Student
 * @Description: TODO
 * @date 2019/3/717:28
 */



public class QuestionsServiceImpl implements QuestionsService {
    @Autowired
    ChoicesMapper choicesMapper;
    CompletionsMapper completionsMapper;


   /**
     * RuleVo 组卷规则
     * @param
     * @param
     * @return
     */

   @Override
    public List<QuestionVo> getQuestionArray(RuleVO ruleVO){


        List<QuestionVo> questionlist =new ArrayList<>();
        if(ruleVO.getChoiceNum()>0){//通过数量判断该类型试题是否进行组卷
            List<QuestionVo> list =new ArrayList<>();
            List<Choices> choices= choicesMapper.selectByPoint(ruleVO.getPoint());
            for(int i=0;i<choices.size();i++){
                QuestionVo questionVo=new QuestionVo();
                questionVo.setId(choices.get(i).getChoice_id());
                questionVo.setStem(choices.get(i).getChoice_content());
                questionVo.setType(1);
                questionVo.setScore(ruleVO.getChoiceScore());
                questionVo.setChoice1(choices.get(i).getChoice_first());
                questionVo.setChoice2(choices.get(i).getChoice_second());
                questionVo.setChoice3(choices.get(i).getChoice_third());
                questionVo.setChoice4(choices.get(i).getChoice_fourth());
                questionVo.setAnswer(choices.get(i).getChoice_answer());
                questionVo.setUserName(choices.get(i).getTeachers().getTeacher_name());
                questionVo.setCreateTime(choices.get(i).getChoice_time());
                list.add(questionVo);
            }
            //从list中选取指定数目的选择题
           List<QuestionVo> list1= TrUtil.getRandomList(list,ruleVO.getChoiceNum());
           questionlist.addAll(list1);



      }
       if(ruleVO.getCompletionsNum()>0){//通过数量判断该类型试题是否进行组卷
           List<QuestionVo> list =new ArrayList<>();
           List<Completions> completions= completionsMapper.selectByPoint(ruleVO.getPoint());
           for(int i=0;i<completions.size();i++){
               QuestionVo questionVo=new QuestionVo();
               questionVo.setId(completions.get(i).getCompletion_id());
               questionVo.setType(2);
               questionVo.setStem(completions.get(i).getCompletion_content());
               questionVo.setScore(ruleVO.getChoiceScore());
               questionVo.setAnswer(completions.get(i).getCompletion_answer());
               questionVo.setUserName(completions.get(i).getTeachers().getTeacher_name());
               questionVo.setCreateTime(completions.get(i).getChoice_time());
               list.add(questionVo);
           }
           //从list中选取指定数目的选择题
           List<QuestionVo> list1= TrUtil.getRandomList(list,ruleVO.getCompletionsNum());
           questionlist.addAll(list1);



       }
          return questionlist;
    }

    @Override
    public List<QuestionVo> getQuestionWithoutId(int type,double score,int id) {
        List<QuestionVo> questionlist =new ArrayList<>();
       if(type==1){
        List<Choices> choices= choicesMapper.selectById(id);
        for(int i=0;i<choices.size();i++) {
            QuestionVo questionVo = new QuestionVo();
            questionVo.setId(choices.get(i).getChoice_id());
            questionVo.setStem(choices.get(i).getChoice_content());
            questionVo.setType(1);
            questionVo.setScore(score);
            questionVo.setChoice1(choices.get(i).getChoice_first());
            questionVo.setChoice2(choices.get(i).getChoice_second());
            questionVo.setChoice3(choices.get(i).getChoice_third());
            questionVo.setChoice4(choices.get(i).getChoice_fourth());
            questionVo.setAnswer(choices.get(i).getChoice_answer());
            questionVo.setUserName(choices.get(i).getTeachers().getTeacher_name());
            questionVo.setCreateTime(choices.get(i).getChoice_time());
            questionlist .add(questionVo);
          }

        }
        //其他类型
        return questionlist;
    }
}

