package com.test.entity;

import java.util.Date;

public class Papers {
    private Integer paper_id;

    private Date paper_date;

    private String teacher_id;

    private Double difficulty;

    private String point;

    private String paper_content;

    public Teachers getTeachers() {
        return teachers;
    }

    public void setTeachers(Teachers teachers) {
        this.teachers = teachers;
    }

    private Teachers teachers;

    public Integer getPaper_id() {
        return paper_id;
    }

    public void setPaper_id(Integer paper_id) {
        this.paper_id = paper_id;
    }

    public Date getPaper_date() {
        return paper_date;
    }

    public void setPaper_date(Date paper_date) {
        this.paper_date = paper_date;
    }

    public String getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(String teacher_id) {
        this.teacher_id = teacher_id == null ? null : teacher_id.trim();
    }

    public Double getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Double difficulty) {
        this.difficulty = difficulty;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point == null ? null : point.trim();
    }

    public String getPaper_content() {
        return paper_content;
    }

    public void setPaper_content(String paper_content) {
        this.paper_content = paper_content == null ? null : paper_content.trim();
    }
}