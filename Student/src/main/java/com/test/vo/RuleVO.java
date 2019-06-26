package com.test.vo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author 张敏
 * @Title: RuleVO
 * @ProjectName Student
 * @Description: TODO
 * @date 2019/3/814:06
 */
public class RuleVO {
    /**
     * 试卷总分
     */
    private int totalMark;
    /**
     * 试卷期望难度系数
     */
    private double difficulty;
    /**
     * 单选题数量
     */
    private int choiceNum;
    /**
     * 单选题单个分值
     */
    private double choiceScore;
    /**
     * 填空题数量
     */
    private int completionsNum;
    /**
     * 填空题单个分值
     */
    private double completionsScore;
    /**
     * 判断题数量
     */
    private int judgmentsNum;
    /**
     * 判断题单个分值
     */
    private double judgmentsScore;
    /**
     * 名词解释数量
     */
    private int definitionsNum;
    /**
     * 名词解释单个分值
     */
    private double definitionsScore;
    /**
     * 简答题个数
     */
    private  int shortAnswerNum;
    /**
     * 简答题单个分值
     */
    private  double shortAnswerScore;
    /**
     * 论述题个数
     */
    private int discussionsNum;
    /**
     * 论述题单个分值
     */
    private double discussionsScore;

    /**
     * 试卷包含的知识点
     */
    private String  point;

    public int getTotalMark() {
        return totalMark;
    }

    public void setTotalMark(int totalMark) {
        this.totalMark = totalMark;
    }

    public double getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(double difficulty) {
        this.difficulty = difficulty;
    }

    public int getChoiceNum() {
        return choiceNum;
    }

    public void setChoiceNum(int choiceNum) {
        this.choiceNum = choiceNum;
    }

    public double getChoiceScore() {
        return choiceScore;
    }

    public void setChoiceScore(double choiceScore) {
        this.choiceScore = choiceScore;
    }

    public int getCompletionsNum() {
        return completionsNum;
    }

    public void setCompletionsNum(int completionsNum) {
        this.completionsNum = completionsNum;
    }

    public double getCompletionsScore() {
        return completionsScore;
    }

    public void setCompletionsScore(double completionsScore) {
        this.completionsScore = completionsScore;
    }

    public int getJudgmentsNum() {
        return judgmentsNum;
    }

    public void setJudgmentsNum(int judgmentsNum) {
        this.judgmentsNum = judgmentsNum;
    }

    public double getJudgmentsScore() {
        return judgmentsScore;
    }

    public void setJudgmentsScore(double judgmentsScore) {
        this.judgmentsScore = judgmentsScore;
    }

    public int getDefinitionsNum() {
        return definitionsNum;
    }

    public void setDefinitionsNum(int definitionsNum) {
        this.definitionsNum = definitionsNum;
    }

    public double getDefinitionsScore() {
        return definitionsScore;
    }

    public void setDefinitionsScore(double definitionsScore) {
        this.definitionsScore = definitionsScore;
    }

    public int getDiscussionsNum() {
        return discussionsNum;
    }

    public void setDiscussionsNum(int discussionsNum) {
        this.discussionsNum = discussionsNum;
    }

    public Double getDiscussionsScore() {
        return discussionsScore;
    }

    public void setDiscussionsScore(Double discussionsScore) {
        this.discussionsScore = discussionsScore;
    }

    public int getShortAnswerNum() {
        return shortAnswerNum;
    }

    public void setShortAnswerNum(int shortAnswerNum) {
        this.shortAnswerNum = shortAnswerNum;
    }

    public double getShortAnswerScore() {
        return shortAnswerScore;
    }

    public void setShortAnswerScore(double shortAnswerScore) {
        this.shortAnswerScore = shortAnswerScore;
    }

    public void setDiscussionsScore(double discussionsScore) {
        this.discussionsScore = discussionsScore;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }
}
