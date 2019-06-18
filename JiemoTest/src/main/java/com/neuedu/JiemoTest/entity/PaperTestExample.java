package com.neuedu.JiemoTest.entity;

import java.util.ArrayList;
import java.util.List;

public class PaperTestExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PaperTestExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andPaperidIsNull() {
            addCriterion("paperId is null");
            return (Criteria) this;
        }

        public Criteria andPaperidIsNotNull() {
            addCriterion("paperId is not null");
            return (Criteria) this;
        }

        public Criteria andPaperidEqualTo(Integer value) {
            addCriterion("paperId =", value, "paperid");
            return (Criteria) this;
        }

        public Criteria andPaperidNotEqualTo(Integer value) {
            addCriterion("paperId <>", value, "paperid");
            return (Criteria) this;
        }

        public Criteria andPaperidGreaterThan(Integer value) {
            addCriterion("paperId >", value, "paperid");
            return (Criteria) this;
        }

        public Criteria andPaperidGreaterThanOrEqualTo(Integer value) {
            addCriterion("paperId >=", value, "paperid");
            return (Criteria) this;
        }

        public Criteria andPaperidLessThan(Integer value) {
            addCriterion("paperId <", value, "paperid");
            return (Criteria) this;
        }

        public Criteria andPaperidLessThanOrEqualTo(Integer value) {
            addCriterion("paperId <=", value, "paperid");
            return (Criteria) this;
        }

        public Criteria andPaperidIn(List<Integer> values) {
            addCriterion("paperId in", values, "paperid");
            return (Criteria) this;
        }

        public Criteria andPaperidNotIn(List<Integer> values) {
            addCriterion("paperId not in", values, "paperid");
            return (Criteria) this;
        }

        public Criteria andPaperidBetween(Integer value1, Integer value2) {
            addCriterion("paperId between", value1, value2, "paperid");
            return (Criteria) this;
        }

        public Criteria andPaperidNotBetween(Integer value1, Integer value2) {
            addCriterion("paperId not between", value1, value2, "paperid");
            return (Criteria) this;
        }

        public Criteria andExamidIsNull() {
            addCriterion("examId is null");
            return (Criteria) this;
        }

        public Criteria andExamidIsNotNull() {
            addCriterion("examId is not null");
            return (Criteria) this;
        }

        public Criteria andExamidEqualTo(Integer value) {
            addCriterion("examId =", value, "examid");
            return (Criteria) this;
        }

        public Criteria andExamidNotEqualTo(Integer value) {
            addCriterion("examId <>", value, "examid");
            return (Criteria) this;
        }

        public Criteria andExamidGreaterThan(Integer value) {
            addCriterion("examId >", value, "examid");
            return (Criteria) this;
        }

        public Criteria andExamidGreaterThanOrEqualTo(Integer value) {
            addCriterion("examId >=", value, "examid");
            return (Criteria) this;
        }

        public Criteria andExamidLessThan(Integer value) {
            addCriterion("examId <", value, "examid");
            return (Criteria) this;
        }

        public Criteria andExamidLessThanOrEqualTo(Integer value) {
            addCriterion("examId <=", value, "examid");
            return (Criteria) this;
        }

        public Criteria andExamidIn(List<Integer> values) {
            addCriterion("examId in", values, "examid");
            return (Criteria) this;
        }

        public Criteria andExamidNotIn(List<Integer> values) {
            addCriterion("examId not in", values, "examid");
            return (Criteria) this;
        }

        public Criteria andExamidBetween(Integer value1, Integer value2) {
            addCriterion("examId between", value1, value2, "examid");
            return (Criteria) this;
        }

        public Criteria andExamidNotBetween(Integer value1, Integer value2) {
            addCriterion("examId not between", value1, value2, "examid");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userId is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userId is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Integer value) {
            addCriterion("userId =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Integer value) {
            addCriterion("userId <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Integer value) {
            addCriterion("userId >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("userId >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Integer value) {
            addCriterion("userId <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Integer value) {
            addCriterion("userId <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Integer> values) {
            addCriterion("userId in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Integer> values) {
            addCriterion("userId not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Integer value1, Integer value2) {
            addCriterion("userId between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("userId not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andExamtitleIsNull() {
            addCriterion("examTitle is null");
            return (Criteria) this;
        }

        public Criteria andExamtitleIsNotNull() {
            addCriterion("examTitle is not null");
            return (Criteria) this;
        }

        public Criteria andExamtitleEqualTo(String value) {
            addCriterion("examTitle =", value, "examtitle");
            return (Criteria) this;
        }

        public Criteria andExamtitleNotEqualTo(String value) {
            addCriterion("examTitle <>", value, "examtitle");
            return (Criteria) this;
        }

        public Criteria andExamtitleGreaterThan(String value) {
            addCriterion("examTitle >", value, "examtitle");
            return (Criteria) this;
        }

        public Criteria andExamtitleGreaterThanOrEqualTo(String value) {
            addCriterion("examTitle >=", value, "examtitle");
            return (Criteria) this;
        }

        public Criteria andExamtitleLessThan(String value) {
            addCriterion("examTitle <", value, "examtitle");
            return (Criteria) this;
        }

        public Criteria andExamtitleLessThanOrEqualTo(String value) {
            addCriterion("examTitle <=", value, "examtitle");
            return (Criteria) this;
        }

        public Criteria andExamtitleLike(String value) {
            addCriterion("examTitle like", value, "examtitle");
            return (Criteria) this;
        }

        public Criteria andExamtitleNotLike(String value) {
            addCriterion("examTitle not like", value, "examtitle");
            return (Criteria) this;
        }

        public Criteria andExamtitleIn(List<String> values) {
            addCriterion("examTitle in", values, "examtitle");
            return (Criteria) this;
        }

        public Criteria andExamtitleNotIn(List<String> values) {
            addCriterion("examTitle not in", values, "examtitle");
            return (Criteria) this;
        }

        public Criteria andExamtitleBetween(String value1, String value2) {
            addCriterion("examTitle between", value1, value2, "examtitle");
            return (Criteria) this;
        }

        public Criteria andExamtitleNotBetween(String value1, String value2) {
            addCriterion("examTitle not between", value1, value2, "examtitle");
            return (Criteria) this;
        }

        public Criteria andPaperstateIsNull() {
            addCriterion("paperState is null");
            return (Criteria) this;
        }

        public Criteria andPaperstateIsNotNull() {
            addCriterion("paperState is not null");
            return (Criteria) this;
        }

        public Criteria andPaperstateEqualTo(Integer value) {
            addCriterion("paperState =", value, "paperstate");
            return (Criteria) this;
        }

        public Criteria andPaperstateNotEqualTo(Integer value) {
            addCriterion("paperState <>", value, "paperstate");
            return (Criteria) this;
        }

        public Criteria andPaperstateGreaterThan(Integer value) {
            addCriterion("paperState >", value, "paperstate");
            return (Criteria) this;
        }

        public Criteria andPaperstateGreaterThanOrEqualTo(Integer value) {
            addCriterion("paperState >=", value, "paperstate");
            return (Criteria) this;
        }

        public Criteria andPaperstateLessThan(Integer value) {
            addCriterion("paperState <", value, "paperstate");
            return (Criteria) this;
        }

        public Criteria andPaperstateLessThanOrEqualTo(Integer value) {
            addCriterion("paperState <=", value, "paperstate");
            return (Criteria) this;
        }

        public Criteria andPaperstateIn(List<Integer> values) {
            addCriterion("paperState in", values, "paperstate");
            return (Criteria) this;
        }

        public Criteria andPaperstateNotIn(List<Integer> values) {
            addCriterion("paperState not in", values, "paperstate");
            return (Criteria) this;
        }

        public Criteria andPaperstateBetween(Integer value1, Integer value2) {
            addCriterion("paperState between", value1, value2, "paperstate");
            return (Criteria) this;
        }

        public Criteria andPaperstateNotBetween(Integer value1, Integer value2) {
            addCriterion("paperState not between", value1, value2, "paperstate");
            return (Criteria) this;
        }

        public Criteria andParticipatetimeIsNull() {
            addCriterion("participateTime is null");
            return (Criteria) this;
        }

        public Criteria andParticipatetimeIsNotNull() {
            addCriterion("participateTime is not null");
            return (Criteria) this;
        }

        public Criteria andParticipatetimeEqualTo(Integer value) {
            addCriterion("participateTime =", value, "participatetime");
            return (Criteria) this;
        }

        public Criteria andParticipatetimeNotEqualTo(Integer value) {
            addCriterion("participateTime <>", value, "participatetime");
            return (Criteria) this;
        }

        public Criteria andParticipatetimeGreaterThan(Integer value) {
            addCriterion("participateTime >", value, "participatetime");
            return (Criteria) this;
        }

        public Criteria andParticipatetimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("participateTime >=", value, "participatetime");
            return (Criteria) this;
        }

        public Criteria andParticipatetimeLessThan(Integer value) {
            addCriterion("participateTime <", value, "participatetime");
            return (Criteria) this;
        }

        public Criteria andParticipatetimeLessThanOrEqualTo(Integer value) {
            addCriterion("participateTime <=", value, "participatetime");
            return (Criteria) this;
        }

        public Criteria andParticipatetimeIn(List<Integer> values) {
            addCriterion("participateTime in", values, "participatetime");
            return (Criteria) this;
        }

        public Criteria andParticipatetimeNotIn(List<Integer> values) {
            addCriterion("participateTime not in", values, "participatetime");
            return (Criteria) this;
        }

        public Criteria andParticipatetimeBetween(Integer value1, Integer value2) {
            addCriterion("participateTime between", value1, value2, "participatetime");
            return (Criteria) this;
        }

        public Criteria andParticipatetimeNotBetween(Integer value1, Integer value2) {
            addCriterion("participateTime not between", value1, value2, "participatetime");
            return (Criteria) this;
        }

        public Criteria andSubmittimeIsNull() {
            addCriterion("submitTime is null");
            return (Criteria) this;
        }

        public Criteria andSubmittimeIsNotNull() {
            addCriterion("submitTime is not null");
            return (Criteria) this;
        }

        public Criteria andSubmittimeEqualTo(Integer value) {
            addCriterion("submitTime =", value, "submittime");
            return (Criteria) this;
        }

        public Criteria andSubmittimeNotEqualTo(Integer value) {
            addCriterion("submitTime <>", value, "submittime");
            return (Criteria) this;
        }

        public Criteria andSubmittimeGreaterThan(Integer value) {
            addCriterion("submitTime >", value, "submittime");
            return (Criteria) this;
        }

        public Criteria andSubmittimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("submitTime >=", value, "submittime");
            return (Criteria) this;
        }

        public Criteria andSubmittimeLessThan(Integer value) {
            addCriterion("submitTime <", value, "submittime");
            return (Criteria) this;
        }

        public Criteria andSubmittimeLessThanOrEqualTo(Integer value) {
            addCriterion("submitTime <=", value, "submittime");
            return (Criteria) this;
        }

        public Criteria andSubmittimeIn(List<Integer> values) {
            addCriterion("submitTime in", values, "submittime");
            return (Criteria) this;
        }

        public Criteria andSubmittimeNotIn(List<Integer> values) {
            addCriterion("submitTime not in", values, "submittime");
            return (Criteria) this;
        }

        public Criteria andSubmittimeBetween(Integer value1, Integer value2) {
            addCriterion("submitTime between", value1, value2, "submittime");
            return (Criteria) this;
        }

        public Criteria andSubmittimeNotBetween(Integer value1, Integer value2) {
            addCriterion("submitTime not between", value1, value2, "submittime");
            return (Criteria) this;
        }

        public Criteria andChangewindowsnumIsNull() {
            addCriterion("changeWindowsNum is null");
            return (Criteria) this;
        }

        public Criteria andChangewindowsnumIsNotNull() {
            addCriterion("changeWindowsNum is not null");
            return (Criteria) this;
        }

        public Criteria andChangewindowsnumEqualTo(Integer value) {
            addCriterion("changeWindowsNum =", value, "changewindowsnum");
            return (Criteria) this;
        }

        public Criteria andChangewindowsnumNotEqualTo(Integer value) {
            addCriterion("changeWindowsNum <>", value, "changewindowsnum");
            return (Criteria) this;
        }

        public Criteria andChangewindowsnumGreaterThan(Integer value) {
            addCriterion("changeWindowsNum >", value, "changewindowsnum");
            return (Criteria) this;
        }

        public Criteria andChangewindowsnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("changeWindowsNum >=", value, "changewindowsnum");
            return (Criteria) this;
        }

        public Criteria andChangewindowsnumLessThan(Integer value) {
            addCriterion("changeWindowsNum <", value, "changewindowsnum");
            return (Criteria) this;
        }

        public Criteria andChangewindowsnumLessThanOrEqualTo(Integer value) {
            addCriterion("changeWindowsNum <=", value, "changewindowsnum");
            return (Criteria) this;
        }

        public Criteria andChangewindowsnumIn(List<Integer> values) {
            addCriterion("changeWindowsNum in", values, "changewindowsnum");
            return (Criteria) this;
        }

        public Criteria andChangewindowsnumNotIn(List<Integer> values) {
            addCriterion("changeWindowsNum not in", values, "changewindowsnum");
            return (Criteria) this;
        }

        public Criteria andChangewindowsnumBetween(Integer value1, Integer value2) {
            addCriterion("changeWindowsNum between", value1, value2, "changewindowsnum");
            return (Criteria) this;
        }

        public Criteria andChangewindowsnumNotBetween(Integer value1, Integer value2) {
            addCriterion("changeWindowsNum not between", value1, value2, "changewindowsnum");
            return (Criteria) this;
        }

        public Criteria andIfteacherdeleteIsNull() {
            addCriterion("ifTeacherDelete is null");
            return (Criteria) this;
        }

        public Criteria andIfteacherdeleteIsNotNull() {
            addCriterion("ifTeacherDelete is not null");
            return (Criteria) this;
        }

        public Criteria andIfteacherdeleteEqualTo(Integer value) {
            addCriterion("ifTeacherDelete =", value, "ifteacherdelete");
            return (Criteria) this;
        }

        public Criteria andIfteacherdeleteNotEqualTo(Integer value) {
            addCriterion("ifTeacherDelete <>", value, "ifteacherdelete");
            return (Criteria) this;
        }

        public Criteria andIfteacherdeleteGreaterThan(Integer value) {
            addCriterion("ifTeacherDelete >", value, "ifteacherdelete");
            return (Criteria) this;
        }

        public Criteria andIfteacherdeleteGreaterThanOrEqualTo(Integer value) {
            addCriterion("ifTeacherDelete >=", value, "ifteacherdelete");
            return (Criteria) this;
        }

        public Criteria andIfteacherdeleteLessThan(Integer value) {
            addCriterion("ifTeacherDelete <", value, "ifteacherdelete");
            return (Criteria) this;
        }

        public Criteria andIfteacherdeleteLessThanOrEqualTo(Integer value) {
            addCriterion("ifTeacherDelete <=", value, "ifteacherdelete");
            return (Criteria) this;
        }

        public Criteria andIfteacherdeleteIn(List<Integer> values) {
            addCriterion("ifTeacherDelete in", values, "ifteacherdelete");
            return (Criteria) this;
        }

        public Criteria andIfteacherdeleteNotIn(List<Integer> values) {
            addCriterion("ifTeacherDelete not in", values, "ifteacherdelete");
            return (Criteria) this;
        }

        public Criteria andIfteacherdeleteBetween(Integer value1, Integer value2) {
            addCriterion("ifTeacherDelete between", value1, value2, "ifteacherdelete");
            return (Criteria) this;
        }

        public Criteria andIfteacherdeleteNotBetween(Integer value1, Integer value2) {
            addCriterion("ifTeacherDelete not between", value1, value2, "ifteacherdelete");
            return (Criteria) this;
        }

        public Criteria andStudentgradeIsNull() {
            addCriterion("studentGrade is null");
            return (Criteria) this;
        }

        public Criteria andStudentgradeIsNotNull() {
            addCriterion("studentGrade is not null");
            return (Criteria) this;
        }

        public Criteria andStudentgradeEqualTo(Float value) {
            addCriterion("studentGrade =", value, "studentgrade");
            return (Criteria) this;
        }

        public Criteria andStudentgradeNotEqualTo(Float value) {
            addCriterion("studentGrade <>", value, "studentgrade");
            return (Criteria) this;
        }

        public Criteria andStudentgradeGreaterThan(Float value) {
            addCriterion("studentGrade >", value, "studentgrade");
            return (Criteria) this;
        }

        public Criteria andStudentgradeGreaterThanOrEqualTo(Float value) {
            addCriterion("studentGrade >=", value, "studentgrade");
            return (Criteria) this;
        }

        public Criteria andStudentgradeLessThan(Float value) {
            addCriterion("studentGrade <", value, "studentgrade");
            return (Criteria) this;
        }

        public Criteria andStudentgradeLessThanOrEqualTo(Float value) {
            addCriterion("studentGrade <=", value, "studentgrade");
            return (Criteria) this;
        }

        public Criteria andStudentgradeIn(List<Float> values) {
            addCriterion("studentGrade in", values, "studentgrade");
            return (Criteria) this;
        }

        public Criteria andStudentgradeNotIn(List<Float> values) {
            addCriterion("studentGrade not in", values, "studentgrade");
            return (Criteria) this;
        }

        public Criteria andStudentgradeBetween(Float value1, Float value2) {
            addCriterion("studentGrade between", value1, value2, "studentgrade");
            return (Criteria) this;
        }

        public Criteria andStudentgradeNotBetween(Float value1, Float value2) {
            addCriterion("studentGrade not between", value1, value2, "studentgrade");
            return (Criteria) this;
        }

        public Criteria andSpare1IsNull() {
            addCriterion("spare_1 is null");
            return (Criteria) this;
        }

        public Criteria andSpare1IsNotNull() {
            addCriterion("spare_1 is not null");
            return (Criteria) this;
        }

        public Criteria andSpare1EqualTo(Integer value) {
            addCriterion("spare_1 =", value, "spare1");
            return (Criteria) this;
        }

        public Criteria andSpare1NotEqualTo(Integer value) {
            addCriterion("spare_1 <>", value, "spare1");
            return (Criteria) this;
        }

        public Criteria andSpare1GreaterThan(Integer value) {
            addCriterion("spare_1 >", value, "spare1");
            return (Criteria) this;
        }

        public Criteria andSpare1GreaterThanOrEqualTo(Integer value) {
            addCriterion("spare_1 >=", value, "spare1");
            return (Criteria) this;
        }

        public Criteria andSpare1LessThan(Integer value) {
            addCriterion("spare_1 <", value, "spare1");
            return (Criteria) this;
        }

        public Criteria andSpare1LessThanOrEqualTo(Integer value) {
            addCriterion("spare_1 <=", value, "spare1");
            return (Criteria) this;
        }

        public Criteria andSpare1In(List<Integer> values) {
            addCriterion("spare_1 in", values, "spare1");
            return (Criteria) this;
        }

        public Criteria andSpare1NotIn(List<Integer> values) {
            addCriterion("spare_1 not in", values, "spare1");
            return (Criteria) this;
        }

        public Criteria andSpare1Between(Integer value1, Integer value2) {
            addCriterion("spare_1 between", value1, value2, "spare1");
            return (Criteria) this;
        }

        public Criteria andSpare1NotBetween(Integer value1, Integer value2) {
            addCriterion("spare_1 not between", value1, value2, "spare1");
            return (Criteria) this;
        }

        public Criteria andSpare2IsNull() {
            addCriterion("spare_2 is null");
            return (Criteria) this;
        }

        public Criteria andSpare2IsNotNull() {
            addCriterion("spare_2 is not null");
            return (Criteria) this;
        }

        public Criteria andSpare2EqualTo(Integer value) {
            addCriterion("spare_2 =", value, "spare2");
            return (Criteria) this;
        }

        public Criteria andSpare2NotEqualTo(Integer value) {
            addCriterion("spare_2 <>", value, "spare2");
            return (Criteria) this;
        }

        public Criteria andSpare2GreaterThan(Integer value) {
            addCriterion("spare_2 >", value, "spare2");
            return (Criteria) this;
        }

        public Criteria andSpare2GreaterThanOrEqualTo(Integer value) {
            addCriterion("spare_2 >=", value, "spare2");
            return (Criteria) this;
        }

        public Criteria andSpare2LessThan(Integer value) {
            addCriterion("spare_2 <", value, "spare2");
            return (Criteria) this;
        }

        public Criteria andSpare2LessThanOrEqualTo(Integer value) {
            addCriterion("spare_2 <=", value, "spare2");
            return (Criteria) this;
        }

        public Criteria andSpare2In(List<Integer> values) {
            addCriterion("spare_2 in", values, "spare2");
            return (Criteria) this;
        }

        public Criteria andSpare2NotIn(List<Integer> values) {
            addCriterion("spare_2 not in", values, "spare2");
            return (Criteria) this;
        }

        public Criteria andSpare2Between(Integer value1, Integer value2) {
            addCriterion("spare_2 between", value1, value2, "spare2");
            return (Criteria) this;
        }

        public Criteria andSpare2NotBetween(Integer value1, Integer value2) {
            addCriterion("spare_2 not between", value1, value2, "spare2");
            return (Criteria) this;
        }

        public Criteria andSpare3IsNull() {
            addCriterion("spare_3 is null");
            return (Criteria) this;
        }

        public Criteria andSpare3IsNotNull() {
            addCriterion("spare_3 is not null");
            return (Criteria) this;
        }

        public Criteria andSpare3EqualTo(String value) {
            addCriterion("spare_3 =", value, "spare3");
            return (Criteria) this;
        }

        public Criteria andSpare3NotEqualTo(String value) {
            addCriterion("spare_3 <>", value, "spare3");
            return (Criteria) this;
        }

        public Criteria andSpare3GreaterThan(String value) {
            addCriterion("spare_3 >", value, "spare3");
            return (Criteria) this;
        }

        public Criteria andSpare3GreaterThanOrEqualTo(String value) {
            addCriterion("spare_3 >=", value, "spare3");
            return (Criteria) this;
        }

        public Criteria andSpare3LessThan(String value) {
            addCriterion("spare_3 <", value, "spare3");
            return (Criteria) this;
        }

        public Criteria andSpare3LessThanOrEqualTo(String value) {
            addCriterion("spare_3 <=", value, "spare3");
            return (Criteria) this;
        }

        public Criteria andSpare3Like(String value) {
            addCriterion("spare_3 like", value, "spare3");
            return (Criteria) this;
        }

        public Criteria andSpare3NotLike(String value) {
            addCriterion("spare_3 not like", value, "spare3");
            return (Criteria) this;
        }

        public Criteria andSpare3In(List<String> values) {
            addCriterion("spare_3 in", values, "spare3");
            return (Criteria) this;
        }

        public Criteria andSpare3NotIn(List<String> values) {
            addCriterion("spare_3 not in", values, "spare3");
            return (Criteria) this;
        }

        public Criteria andSpare3Between(String value1, String value2) {
            addCriterion("spare_3 between", value1, value2, "spare3");
            return (Criteria) this;
        }

        public Criteria andSpare3NotBetween(String value1, String value2) {
            addCriterion("spare_3 not between", value1, value2, "spare3");
            return (Criteria) this;
        }

        public Criteria andSpare4IsNull() {
            addCriterion("spare_4 is null");
            return (Criteria) this;
        }

        public Criteria andSpare4IsNotNull() {
            addCriterion("spare_4 is not null");
            return (Criteria) this;
        }

        public Criteria andSpare4EqualTo(String value) {
            addCriterion("spare_4 =", value, "spare4");
            return (Criteria) this;
        }

        public Criteria andSpare4NotEqualTo(String value) {
            addCriterion("spare_4 <>", value, "spare4");
            return (Criteria) this;
        }

        public Criteria andSpare4GreaterThan(String value) {
            addCriterion("spare_4 >", value, "spare4");
            return (Criteria) this;
        }

        public Criteria andSpare4GreaterThanOrEqualTo(String value) {
            addCriterion("spare_4 >=", value, "spare4");
            return (Criteria) this;
        }

        public Criteria andSpare4LessThan(String value) {
            addCriterion("spare_4 <", value, "spare4");
            return (Criteria) this;
        }

        public Criteria andSpare4LessThanOrEqualTo(String value) {
            addCriterion("spare_4 <=", value, "spare4");
            return (Criteria) this;
        }

        public Criteria andSpare4Like(String value) {
            addCriterion("spare_4 like", value, "spare4");
            return (Criteria) this;
        }

        public Criteria andSpare4NotLike(String value) {
            addCriterion("spare_4 not like", value, "spare4");
            return (Criteria) this;
        }

        public Criteria andSpare4In(List<String> values) {
            addCriterion("spare_4 in", values, "spare4");
            return (Criteria) this;
        }

        public Criteria andSpare4NotIn(List<String> values) {
            addCriterion("spare_4 not in", values, "spare4");
            return (Criteria) this;
        }

        public Criteria andSpare4Between(String value1, String value2) {
            addCriterion("spare_4 between", value1, value2, "spare4");
            return (Criteria) this;
        }

        public Criteria andSpare4NotBetween(String value1, String value2) {
            addCriterion("spare_4 not between", value1, value2, "spare4");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}