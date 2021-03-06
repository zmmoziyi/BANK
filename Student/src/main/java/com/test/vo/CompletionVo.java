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
public class CompletionVo {
    private Integer completion_id;

    private String completion_content;

    private String completion_answer;

    private double completion_difficulty;

    private String point;

    private String teacher_name;

    public Date getChoice_time() {
        return choice_time;
    }

    public void setChoice_time(Date choice_time) {
        this.choice_time = choice_time;
    }

    @DateTimeFormat
    private Date choice_time;



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

    public Integer getCompletion_id() {
        return completion_id;
    }

    public void setCompletion_id(Integer completion_id) {
        this.completion_id = completion_id;
    }

    public String getCompletion_content() {
        return completion_content;
    }

    public void setCompletion_content(String completion_content) {
        this.completion_content = completion_content;
    }

    public String getCompletion_answer() {
        return completion_answer;
    }

    public void setCompletion_answer(String completion_answer) {
        this.completion_answer = completion_answer;
    }

    public double getCompletion_difficulty() {
        return completion_difficulty;
    }

    public void setCompletion_difficulty(double completion_difficulty) {
        this.completion_difficulty = completion_difficulty;
    }
}
