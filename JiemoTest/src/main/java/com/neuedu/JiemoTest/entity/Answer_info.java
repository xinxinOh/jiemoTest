package com.neuedu.JiemoTest.entity;

public class Answer_info extends Answer_infoKey {
    private Integer questionserialnum;

    private String answercontent;

    private Integer score;

    private Integer correctstate;

    private Integer spare1;

    private Integer spare2;

    private String spare3;

    private String spare4;

    public Integer getQuestionserialnum() {
        return questionserialnum;
    }

    public void setQuestionserialnum(Integer questionserialnum) {
        this.questionserialnum = questionserialnum;
    }

    public String getAnswercontent() {
        return answercontent;
    }

    public void setAnswercontent(String answercontent) {
        this.answercontent = answercontent == null ? null : answercontent.trim();
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getCorrectstate() {
        return correctstate;
    }

    public void setCorrectstate(Integer correctstate) {
        this.correctstate = correctstate;
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