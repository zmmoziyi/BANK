package com.test.entity;

import java.util.Date;

public class Discussions {
    private Integer discussion_id;

    private String discussion_content;

    private String discussion_answer;

    private Double discussion_difficulty;

    private String point;

    private String teacher_id;

    private Date discussion_time;

    public Teachers getTeachers() {
        return teachers;
    }

    public void setTeachers(Teachers teachers) {
        this.teachers = teachers;
    }

    private Teachers teachers;

    public Integer getDiscussion_id() {
        return discussion_id;
    }

    public void setDiscussion_id(Integer discussion_id) {
        this.discussion_id = discussion_id;
    }

    public String getDiscussion_content() {
        return discussion_content;
    }

    public void setDiscussion_content(String discussion_content) {
        this.discussion_content = discussion_content == null ? null : discussion_content.trim();
    }

    public String getDiscussion_answer() {
        return discussion_answer;
    }

    public void setDiscussion_answer(String discussion_answer) {
        this.discussion_answer = discussion_answer == null ? null : discussion_answer.trim();
    }

    public Double getDiscussion_difficulty() {
        return discussion_difficulty;
    }

    public void setDiscussion_difficulty(Double discussion_difficulty) {
        this.discussion_difficulty = discussion_difficulty;
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

    public Date getDiscussion_time() {
        return discussion_time;
    }

    public void setDiscussion_time(Date discussion_time) {
        this.discussion_time = discussion_time;
    }
}