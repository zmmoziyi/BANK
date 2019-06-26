package com.test.service.serviceImpl;

import com.test.dao.DiscussionsMapper;
import com.test.dao.JudgmentsMapper;
import com.test.entity.Discussions;
import com.test.entity.Judgments;
import com.test.service.DiscussionService;
import com.test.service.JudgmentService;
import com.test.vo.DiscussionVo;
import com.test.vo.JudgmentVo;
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
public class JudgmentServicesImpl implements JudgmentService {
    @Autowired
    JudgmentsMapper judgmentsMapper;
    //ChoiceVo choiceVo;


    @Override
    public List<Judgments> crateChoice(Double  judgment_difficulty) {
        return null;
    }

    @Override
    public Judgments selectByPrimaryKey(int judgment_id) {
        return judgmentsMapper.selectByPrimaryKey(judgment_id);
    }

    @Override
    public List<Judgments> paper(String point) {
        return judgmentsMapper.selectByPoint(point);
    }

    @Override
    public int addJudgments(Judgments judgments) {
        return judgmentsMapper.insertSelective(judgments);
    }

    @Override
    public int updateJudgments(Judgments judgments) {
        return judgmentsMapper.updateByPrimaryKeySelective(judgments);
    }

    @Override
    public int deleteJudgments(int discussion_id) {
        return judgmentsMapper.deleteByPrimaryKey(discussion_id);
    }

    @Override
    public List<JudgmentVo> selectAll(String point,int before, int after) {
        List<Judgments> judgments=judgmentsMapper.selectAll(point,before,after);

        List <JudgmentVo> list=new ArrayList<JudgmentVo>();
        for(int i = 0;i <judgments .size();i++){
            JudgmentVo judgmentVo=new JudgmentVo();
            judgmentVo.setJudgment_id(judgments.get(i).getJudgment_id());
            judgmentVo.setJudgment_content(judgments.get(i).getJudgment_content());

            judgmentVo.setJudgment_answer(judgments.get(i).getJudgment_answer());
            judgmentVo.setJudgment_difficulty(judgments.get(i).getJudgment_difficulty());
            judgmentVo.setPoint(judgments.get(i).getPoint());
            judgmentVo.setChoice_time(judgments.get(i).getChoice_time());
            judgmentVo.setTeacher_name(judgments.get(i).getTeachers().getTeacher_name());
            list.add(judgmentVo);
        }
        return list;
    }

    @Override
    public int count() {
        return judgmentsMapper.count();
    }
}
