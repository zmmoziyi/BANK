package com.test.vo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author 张敏
 * @Title: PaperVo
 * @ProjectName Student
 * @Description: TODO
 * @date 2019/4/3017:59
 */
public class PaperVo {
    public Integer getPaper_id() {
        return paper_id;
    }

    public void setPaper_id(Integer paper_id) {
        this.paper_id = paper_id;
    }

    private Integer paper_id;

    @DateTimeFormat
    private Date paper_date;

    private String teacher_name;

    private Double difficulty;



    public Date getPaper_date() {
        return paper_date;
    }

    public void setPaper_date(Date paper_date) {
        this.paper_date = paper_date;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
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
        this.point = point;
    }

    public String getPaper_content() {
        return paper_content;
    }

    public void setPaper_content(String paper_content) {
        this.paper_content = paper_content;
    }

    private String point;

    private String paper_content;
}
