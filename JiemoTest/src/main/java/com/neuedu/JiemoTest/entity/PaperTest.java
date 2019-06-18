package com.neuedu.JiemoTest.entity;

public class PaperTest {
    private Integer paperid;

    private Integer examid;

    private Integer userid;

    private String examtitle;

    private Integer paperstate;

    private Integer participatetime;

    private Integer submittime;

    private Integer changewindowsnum;

    private Integer ifteacherdelete;

    private Float studentgrade;

    private Integer spare1;

    private Integer spare2;

    private String spare3;

    private String spare4;

    public Integer getPaperid() {
        return paperid;
    }

    public void setPaperid(Integer paperid) {
        this.paperid = paperid;
    }

    public Integer getExamid() {
        return examid;
    }

    public void setExamid(Integer examid) {
        this.examid = examid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getExamtitle() {
        return examtitle;
    }

    public void setExamtitle(String examtitle) {
        this.examtitle = examtitle == null ? null : examtitle.trim();
    }

    public Integer getPaperstate() {
        return paperstate;
    }

    public void setPaperstate(Integer paperstate) {
        this.paperstate = paperstate;
    }

    public Integer getParticipatetime() {
        return participatetime;
    }

    public void setParticipatetime(Integer participatetime) {
        this.participatetime = participatetime;
    }

    public Integer getSubmittime() {
        return submittime;
    }

    public void setSubmittime(Integer submittime) {
        this.submittime = submittime;
    }

    public Integer getChangewindowsnum() {
        return changewindowsnum;
    }

    public void setChangewindowsnum(Integer changewindowsnum) {
        this.changewindowsnum = changewindowsnum;
    }

    public Integer getIfteacherdelete() {
        return ifteacherdelete;
    }

    public void setIfteacherdelete(Integer ifteacherdelete) {
        this.ifteacherdelete = ifteacherdelete;
    }

    public Float getStudentgrade() {
        return studentgrade;
    }

    public void setStudentgrade(Float studentgrade) {
        this.studentgrade = studentgrade;
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