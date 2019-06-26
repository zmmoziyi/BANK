package com.test.entity;

import java.util.Date;

public class Judgments {
    private Integer judgment_id;

    private String judgment_content;

    private String judgment_answer;

    private Double judgment_difficulty;

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
        this.judgment_content = judgment_content == null ? null : judgment_content.trim();
    }

    public String getJudgment_answer() {
        return judgment_answer;
    }

    public void setJudgment_answer(String judgment_answer) {
        this.judgment_answer = judgment_answer == null ? null : judgment_answer.trim();
    }

    public Double getJudgment_difficulty() {
        return judgment_difficulty;
    }

    public void setJudgment_difficulty(Double judgment_difficulty) {
        this.judgment_difficulty = judgment_difficulty;
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