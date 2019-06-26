package com.test.entity;

import java.util.Date;

public class Choices {
    private Integer choice_id;

    private String choice_content;

    private String choice_first;

    private String choice_second;

    private String choice_third;

    private String choice_fourth;

    private String choice_answer;

    private Double choice_difficulty;

    private String point;

    private String teacher_id;

    private Date choice_time;

    private Teachers teachers;

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
        this.choice_content = choice_content == null ? null : choice_content.trim();
    }

    public String getChoice_first() {
        return choice_first;
    }

    public void setChoice_first(String choice_first) {
        this.choice_first = choice_first == null ? null : choice_first.trim();
    }

    public String getChoice_second() {
        return choice_second;
    }

    public void setChoice_second(String choice_second) {
        this.choice_second = choice_second == null ? null : choice_second.trim();
    }

    public String getChoice_third() {
        return choice_third;
    }

    public void setChoice_third(String choice_third) {
        this.choice_third = choice_third == null ? null : choice_third.trim();
    }

    public String getChoice_fourth() {
        return choice_fourth;
    }

    public void setChoice_fourth(String choice_fourth) {
        this.choice_fourth = choice_fourth == null ? null : choice_fourth.trim();
    }

    public String getChoice_answer() {
        return choice_answer;
    }

    public void setChoice_answer(String choice_answer) {
        this.choice_answer = choice_answer == null ? null : choice_answer.trim();
    }

    public Double getChoice_difficulty() {
        return choice_difficulty;
    }

    public void setChoice_difficulty(Double choice_difficulty) {
        this.choice_difficulty = choice_difficulty;
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

    public Teachers getTeachers() {
        return teachers;
    }

    public void setTeachers(Teachers teachers) {
        this.teachers = teachers;
    }
}