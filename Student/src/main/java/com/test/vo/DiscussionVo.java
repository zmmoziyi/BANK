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
public class DiscussionVo {
    private Integer discussion_id;

    private String discussion_content;

    private String discussion_answer;

    private double discussion_difficulty;

    private String point;

    private String teacher_name;


    @DateTimeFormat
    private Date choice_time;


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
        this.discussion_content = discussion_content;
    }

    public String getDiscussion_answer() {
        return discussion_answer;
    }

    public void setDiscussion_answer(String discussion_answer) {
        this.discussion_answer = discussion_answer;
    }

    public double getDiscussion_difficulty() {
        return discussion_difficulty;
    }

    public void setDiscussion_difficulty(double discussion_difficulty) {
        this.discussion_difficulty = discussion_difficulty;
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
