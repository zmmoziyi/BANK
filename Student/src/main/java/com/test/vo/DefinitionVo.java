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
public class DefinitionVo {
    private Integer definition_id;

    private String definition_content;

    private String definition_answer;

    private double definition_difficulty;

    private String point;

    private String teacher_name;


    @DateTimeFormat
    private Date choice_time;


    public Integer getDefinition_id() {
        return definition_id;
    }

    public void setDefinition_id(Integer definition_id) {
        this.definition_id = definition_id;
    }

    public String getDefinition_content() {
        return definition_content;
    }

    public void setDefinition_content(String definition_content) {
        this.definition_content = definition_content;
    }

    public String getDefinition_answer() {
        return definition_answer;
    }

    public void setDefinition_answer(String definition_answer) {
        this.definition_answer = definition_answer;
    }

    public double getDefinition_difficulty() {
        return definition_difficulty;
    }

    public void setDefinition_difficulty(double definition_difficulty) {
        this.definition_difficulty = definition_difficulty;
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
