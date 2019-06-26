package com.test.entity;

import java.util.Date;

public class Completions {
    private Integer completion_id;

    private String completion_content;

    private String completion_answer;

    private Double completion_difficulty;

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
        this.completion_content = completion_content == null ? null : completion_content.trim();
    }

    public String getCompletion_answer() {
        return completion_answer;
    }

    public void setCompletion_answer(String completion_answer) {
        this.completion_answer = completion_answer == null ? null : completion_answer.trim();
    }

    public Double getCompletion_difficulty() {
        return completion_difficulty;
    }

    public void setCompletion_difficulty(Double completion_difficulty) {
        this.completion_difficulty = completion_difficulty;
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