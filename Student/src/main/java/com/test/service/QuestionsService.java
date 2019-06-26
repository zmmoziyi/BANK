package com.test.service;

import com.test.entity.Choices;

import com.test.vo.Paper;
import com.test.vo.QuestionVo;
import com.test.vo.RuleVO;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 张敏
 * @Title: QuestionsService
 * @ProjectName Student
 * @Description: TODO
 * @date 2019/3/717:27
 */
@Service
public interface QuestionsService {
    public List<QuestionVo> getQuestionArray(RuleVO ruleVO);
    public List<QuestionVo> getQuestionWithoutId(int type,double score, int id);
}