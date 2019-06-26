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
public class ShortAnswerVo {
    private Integer sa_id;

    private String sa_content;

    private String sa_answer;

    private double sa_difficulty;

    private String point;

    private String teacher_name;


    @DateTimeFormat
    private Date choice_time;


    public Integer getSa_id() {
        return sa_id;
    }

    public void setSa_id(Integer sa_id) {
        this.sa_id = sa_id;
    }

    public String getSa_content() {
        return sa_content;
    }

    public void setSa_content(String sa_content) {
        this.sa_content = sa_content;
    }

    public String getSa_answer() {
        return sa_answer;
    }

    public void setSa_answer(String sa_answer) {
        this.sa_answer = sa_answer;
    }

    public double getSa_difficulty() {
        return sa_difficulty;
    }

    public void setSa_difficulty(double sa_difficulty) {
        this.sa_difficulty = sa_difficulty;
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
