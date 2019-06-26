package com.test.vo;




import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 遗传算法中的个体，即一套可能的试卷。对试卷进行编码，而不是对整个题库编码
 *
 * @author: lixiaolin
 * @CreateDate: 2016-4-29 上午10:15:11
 * @version: 1.0
 */
public class Paper {
    /**
     * 个体id
     */
    private int id;
    /**
     * 适应度
     */
    private double adaptationDegree = 0.00;
    /**
     * 知识点覆盖率
     */

    /**
     * 试卷总分
     */
    private double totalScore = 0.00;
    /**
     * 试卷难度系数
     */
    private double difficulty = 0.00;
    /**
     * 个体包含的试题集合
     */
    private List<QuestionVo> questionList = new ArrayList<QuestionVo>();

//清空试题集
    public Paper(int size) {
        for (int i = 0; i < size; i++) {
            questionList.add(null);
        }
    }

    public Paper() {
        super();
    }

    /**
     * 计算试卷总分
     *
     * @return
     */
    public double getTotalScore() {
        if (totalScore == 0) {
            double total = 0;
            for (QuestionVo question : questionList) {
                total += question.getScore();
            }
            totalScore = total;
        }
        return totalScore;
    }

    /**
     * 计算试卷个体难度系数 计算公式： 每题难度*分数求和除总分
     *
     * @return
     */
    public double getDifficulty() {
        if (difficulty == 0) {
            double difficulty = 0;
            for (QuestionVo question : questionList) {
                difficulty += question.getScore() * question.getDifficulty();
            }
            difficulty = difficulty / getTotalScore();
        }
        return difficulty;
    }

    /**
     * 获取试题数量
     *
     * @return
     */
    public int getQuestionSize() {
        return questionList.size();
    }



    /**
     * 计算个体适应度 公式为：f=1-|EP-P|
     * EP为期望难度系数，P为种群个体难度系数，
     *
     *
     * @param rule 组卷规则
     *
     *
     */
    public double GetAdaptationDegree(RuleVO rule) {
        if (adaptationDegree == 0) {
            adaptationDegree =1- Math.abs(rule.getDifficulty()-getDifficulty());
        }
        return adaptationDegree;
    }

    public boolean containsQuestion(QuestionVo question) {
        if (question == null) {
            for (int i = 0; i < questionList.size(); i++) {
                if (questionList.get(i) == null) {
                    return true;
                }
            }
        } else {
            for (QuestionVo aQuestionList : questionList) {
                if (aQuestionList != null) {
                    if (aQuestionList.equals(question)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 增加问题
     *
     * @param question
     */
    public void saveQuestion(int index, QuestionVo question) {
        this.questionList.set(index, question);
        this.totalScore = 0;
        this.adaptationDegree = 0;
        this.difficulty = 0;

    }

    public void addQuestion(QuestionVo question) {
        this.questionList.add(question);
        this.totalScore = 0;
        this.adaptationDegree = 0;
        this.difficulty = 0;

    }

    public QuestionVo getQuestion(int index) {
        return questionList.get(index);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public double getAdaptationDegree() {
        return adaptationDegree;
    }

    public List<QuestionVo> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<QuestionVo> questionList) {
        this.questionList = questionList;
    }

}
