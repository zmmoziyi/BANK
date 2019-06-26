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
public class ChoiceVo {
    private Integer choice_id;

    private String choice_content;

    private String choice_first;

    private String choice_second;

    private String choice_third;

    private String choice_fourth;

    private String choice_answer;

    private double choice_difficulty;

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

    public Integer getChoice_id() {
        return choice_id;
    }

    public void setChoice_id(Integer choice_id) {
        this.choice_id = choice_id;
    }

    public String getChoice_content() {
        return choice_content;
    }

    public void setChoice_content(String choice_content) {
        this.choice_content = choice_content;
    }

    public String getChoice_first() {
        return choice_first;
    }

    public void setChoice_first(String choice_first) {
        this.choice_first = choice_first;
    }

    public String getChoice_second() {
        return choice_second;
    }

    public void setChoice_second(String choice_second) {
        this.choice_second = choice_second;
    }

    public String getChoice_third() {
        return choice_third;
    }

    public void setChoice_third(String choice_third) {
        this.choice_third = choice_third;
    }

    public String getChoice_fourth() {
        return choice_fourth;
    }

    public void setChoice_fourth(String choice_fourth) {
        this.choice_fourth = choice_fourth;
    }

    public String getChoice_answer() {
        return choice_answer;
    }

    public void setChoice_answer(String choice_answer) {
        this.choice_answer = choice_answer;
    }

    public double getChoice_difficulty() {
        return choice_difficulty;
    }

    public void setChoice_difficulty(double choice_difficulty) {
        this.choice_difficulty = choice_difficulty;
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




}
