package com.test.vo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author 张敏
 * @Title: ChoiceVo
 * @ProjectName Student
 * @Description: TODO
 * @date 2019/3/615:12
 */
public class JudgmentVo {
    private Integer judgment_id;

    private String judgment_content;

    private String judgment_answer;

    private double judgment_difficulty;

    private String point;

    private String teacher_name;


    @DateTimeFormat
    private Date choice_time;




    public Integer getJudgment_id() {
        return judgment_id;
    }

    public void setJudgment_id(Integer judgment_id) {
        this.judgment_id = judgment_id;
    }

    public String getJudgment_content() {
        return judgment_content;
    }

    public void setJudgment_content(String judgment_content) {
        this.judgment_content = judgment_content;
    }

    public String getJudgment_answer() {
        return judgment_answer;
    }

    public void setJudgment_answer(String judgment_answer) {
        this.judgment_answer = judgment_answer;
    }

    public double getJudgment_difficulty() {
        return judgment_difficulty;
    }

    public void setJudgment_difficulty(double judgment_difficulty) {
        this.judgment_difficulty = judgment_difficulty;
    }



    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public Date getChoice_time() {
        return choice_time;
    }

    public void setChoice_time(Date choice_time) {
        this.choice_time = choice_time;
    }
}
