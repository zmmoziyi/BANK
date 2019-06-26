package com.test.entity;

import java.util.Date;

public class Definitions {
    private Integer definition_id;

    private String definition_content;

    private String definition_answer;

    private Double definition_difficulty;

    private String point;

    private String teacher_id;

    private Date choice_time;

    public Teachers getTeachers() {
        return teachers;
    }

    public void setTeachers(Teachers teachers) {
        this.teachers = teachers;
    }

    private Teachers teachers;

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
        this.definition_content = definition_content == null ? null : definition_content.trim();
    }

    public String getDefinition_answer() {
        return definition_answer;
    }

    public void setDefinition_answer(String definition_answer) {
        this.definition_answer = definition_answer == null ? null : definition_answer.trim();
    }

    public Double getDefinition_difficulty() {
        return definition_difficulty;
    }

    public void setDefinition_difficulty(Double definition_difficulty) {
        this.definition_difficulty = definition_difficulty;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point == null ? null : point.trim();
    }

    public String getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(String teacher_id) {
        this.teacher_id = teacher_id == null ? null : teacher_id.trim();
    }

    public Date getChoice_time() {
        return choice_time;
    }

    public void setChoice_time(Date choice_time) {
        this.choice_time = choice_time;
    }
}