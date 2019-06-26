package com.test.entity;

import java.util.Date;

public class ShortAnswer {
    private Integer shortAnswer_id;

    private String shortAnswer_content;

    private String shortAnswer_answer;

    private Double shortAnswer_difficulty;

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

    public Integer getShortAnswer_id() {
        return shortAnswer_id;
    }

    public void setShortAnswer_id(Integer shortAnswer_id) {
        this.shortAnswer_id = shortAnswer_id;
    }

    public String getShortAnswer_content() {
        return shortAnswer_content;
    }

    public void setShortAnswer_content(String shortAnswer_content) {
        this.shortAnswer_content = shortAnswer_content == null ? null : shortAnswer_content.trim();
    }

    public String getShortAnswer_answer() {
        return shortAnswer_answer;
    }

    public void setShortAnswer_answer(String shortAnswer_answer) {
        this.shortAnswer_answer = shortAnswer_answer == null ? null : shortAnswer_answer.trim();
    }

    public Double getShortAnswer_difficulty() {
        return shortAnswer_difficulty;
    }

    public void setShortAnswer_difficulty(Double shortAnswer_difficulty) {
        this.shortAnswer_difficulty = shortAnswer_difficulty;
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