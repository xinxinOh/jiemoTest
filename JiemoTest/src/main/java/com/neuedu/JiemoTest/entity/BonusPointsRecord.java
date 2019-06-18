package com.neuedu.JiemoTest.entity;

public class BonusPointsRecord {
    private Integer recordid;

    private Integer userid;

    private Integer bonuspointsnum;

    private Integer operatetype;

    private Integer operatetime;

    private String account;

    private Integer spare1;

    private Integer spare2;

    private String spare3;

    private String spare4;

    public Integer getRecordid() {
        return recordid;
    }

    public void setRecordid(Integer recordid) {
        this.recordid = recordid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getBonuspointsnum() {
        return bonuspointsnum;
    }

    public void setBonuspointsnum(Integer bonuspointsnum) {
        this.bonuspointsnum = bonuspointsnum;
    }

    public Integer getOperatetype() {
        return operatetype;
    }

    public void setOperatetype(Integer operatetype) {
        this.operatetype = operatetype;
    }

    public Integer getOperatetime() {
        return operatetime;
    }

    public void setOperatetime(Integer operatetime) {
        this.operatetime = operatetime;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
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