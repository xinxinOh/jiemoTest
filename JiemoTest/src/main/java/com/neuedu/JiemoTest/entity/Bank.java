package com.neuedu.JiemoTest.entity;

public class Bank {
    private Integer bankid;

    private Integer userid;

    private Integer sourcebankid;

    private String bankname;

    private String bankintroduction;

    private Integer createdate;

    private Integer spare1;

    private Integer spare2;

    private String spare3;

    private String spare4;

    public Integer getBankid() {
        return bankid;
    }

    public void setBankid(Integer bankid) {
        this.bankid = bankid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getSourcebankid() {
        return sourcebankid;
    }

    public void setSourcebankid(Integer sourcebankid) {
        this.sourcebankid = sourcebankid;
    }

    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname == null ? null : bankname.trim();
    }

    public String getBankintroduction() {
        return bankintroduction;
    }

    public void setBankintroduction(String bankintroduction) {
        this.bankintroduction = bankintroduction == null ? null : bankintroduction.trim();
    }

    public Integer getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Integer createdate) {
        this.createdate = createdate;
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