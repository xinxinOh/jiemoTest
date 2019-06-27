package com.neuedu.JiemoTest.entity;

import org.springframework.data.annotation.Id;

public class Exam {
	@Id
    private Integer examid;

    private String examtitle;

    private String examintroduction;

    private Integer userid;

    private Integer sourceexamid;

    private Integer edittime;

    private Integer starttime;

    private Integer endtime;

    private Integer duration;

    private Integer maxtimes;
    
    private Integer questionnum;

    private Integer pointssum;

    private Integer examstate;

    private Integer spare1;

    private Integer spare2;

    private String spare3;

    private String spare4;

    public Integer getExamid() {
        return examid;
    }

    public void setExamid(Integer examid) {
        this.examid = examid;
    }

    public String getExamtitle() {
        return examtitle;
    }

    public void setExamtitle(String examtitle) {
        this.examtitle = examtitle == null ? null : examtitle.trim();
    }

    public String getExamintroduction() {
        return examintroduction;
    }

    public void setExamintroduction(String examintroduction) {
        this.examintroduction = examintroduction == null ? null : examintroduction.trim();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getSourceexamid() {
        return sourceexamid;
    }

    public void setSourceexamid(Integer sourceexamid) {
        this.sourceexamid = sourceexamid;
    }

    public Integer getEdittime() {
        return edittime;
    }

    public void setEdittime(Integer edittime) {
        this.edittime = edittime;
    }

    public Integer getStarttime() {
        return starttime;
    }

    public void setStarttime(Integer starttime) {
        this.starttime = starttime;
    }

    public Integer getEndtime() {
        return endtime;
    }

    public void setEndtime(Integer endtime) {
        this.endtime = endtime;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getMaxtimes() {
        return maxtimes;
    }

    public void setMaxtimes(Integer maxtimes) {
        this.maxtimes = maxtimes;
    }

    public Integer getQuestionnum() {
        return questionnum;
    }

    public void setQuestionnum(Integer questionnum) {
        this.questionnum = questionnum;
    }

    public Integer getPointssum() {
        return pointssum;
    }

    public void setPointssum(Integer pointssum) {
        this.pointssum = pointssum;
    }

    public Integer getExamstate() {
        return examstate;
    }

    public void setExamstate(Integer examstate) {
        this.examstate = examstate;
    }

    public Integer getSpare1() {
        return spare1;
    }

    public void setSpare1(Integer spare1) {
        this.spare1 = spare1;
    }

    public Integer getSpare2() {
        return spare2;
    }

    public void setSpare2(Integer spare2) {
        this.spare2 = spare2;
    }

    public String getSpare3() {
        return spare3;
    }

    public void setSpare3(String spare3) {
        this.spare3 = spare3 == null ? null : spare3.trim();
    }

    public String getSpare4() {
        return spare4;
    }

    public void setSpare4(String spare4) {
        this.spare4 = spare4 == null ? null : spare4.trim();
    }
}