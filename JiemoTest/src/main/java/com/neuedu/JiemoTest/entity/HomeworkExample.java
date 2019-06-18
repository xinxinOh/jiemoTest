package com.neuedu.JiemoTest.entity;

import java.util.ArrayList;
import java.util.List;

public class HomeworkExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HomeworkExample() {
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

        public Criteria andGroupidIsNull() {
            addCriterion("groupId is null");
            return (Criteria) this;
        }

        public Criteria andGroupidIsNotNull() {
            addCriterion("groupId is not null");
            return (Criteria) this;
        }

        public Criteria andGroupidEqualTo(Integer value) {
            addCriterion("groupId =", value, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidNotEqualTo(Integer value) {
            addCriterion("groupId <>", value, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidGreaterThan(Integer value) {
            addCriterion("groupId >", value, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidGreaterThanOrEqualTo(Integer value) {
            addCriterion("groupId >=", value, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidLessThan(Integer value) {
            addCriterion("groupId <", value, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidLessThanOrEqualTo(Integer value) {
            addCriterion("groupId <=", value, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidIn(List<Integer> values) {
            addCriterion("groupId in", values, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidNotIn(List<Integer> values) {
            addCriterion("groupId not in", values, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidBetween(Integer value1, Integer value2) {
            addCriterion("groupId between", value1, value2, "groupid");
            return (Criteria) this;
        }

        public Criteria andGroupidNotBetween(Integer value1, Integer value2) {
            addCriterion("groupId not between", value1, value2, "groupid");
            return (Criteria) this;
        }

        public Criteria andHomeworktimeIsNull() {
            addCriterion("homeworkTime is null");
            return (Criteria) this;
        }

        public Criteria andHomeworktimeIsNotNull() {
            addCriterion("homeworkTime is not null");
            return (Criteria) this;
        }

        public Criteria andHomeworktimeEqualTo(Integer value) {
            addCriterion("homeworkTime =", value, "homeworktime");
            return (Criteria) this;
        }

        public Criteria andHomeworktimeNotEqualTo(Integer value) {
            addCriterion("homeworkTime <>", value, "homeworktime");
            return (Criteria) this;
        }

        public Criteria andHomeworktimeGreaterThan(Integer value) {
            addCriterion("homeworkTime >", value, "homeworktime");
            return (Criteria) this;
        }

        public Criteria andHomeworktimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("homeworkTime >=", value, "homeworktime");
            return (Criteria) this;
        }

        public Criteria andHomeworktimeLessThan(Integer value) {
            addCriterion("homeworkTime <", value, "homeworktime");
            return (Criteria) this;
        }

        public Criteria andHomeworktimeLessThanOrEqualTo(Integer value) {
            addCriterion("homeworkTime <=", value, "homeworktime");
            return (Criteria) this;
        }

        public Criteria andHomeworktimeIn(List<Integer> values) {
            addCriterion("homeworkTime in", values, "homeworktime");
            return (Criteria) this;
        }

        public Criteria andHomeworktimeNotIn(List<Integer> values) {
            addCriterion("homeworkTime not in", values, "homeworktime");
            return (Criteria) this;
        }

        public Criteria andHomeworktimeBetween(Integer value1, Integer value2) {
            addCriterion("homeworkTime between", value1, value2, "homeworktime");
            return (Criteria) this;
        }

        public Criteria andHomeworktimeNotBetween(Integer value1, Integer value2) {
            addCriterion("homeworkTime not between", value1, value2, "homeworktime");
            return (Criteria) this;
        }

        public Criteria andHomeworkintroductionIsNull() {
            addCriterion("homeworkIntroduction is null");
            return (Criteria) this;
        }

        public Criteria andHomeworkintroductionIsNotNull() {
            addCriterion("homeworkIntroduction is not null");
            return (Criteria) this;
        }

        public Criteria andHomeworkintroductionEqualTo(String value) {
            addCriterion("homeworkIntroduction =", value, "homeworkintroduction");
            return (Criteria) this;
        }

        public Criteria andHomeworkintroductionNotEqualTo(String value) {
            addCriterion("homeworkIntroduction <>", value, "homeworkintroduction");
            return (Criteria) this;
        }

        public Criteria andHomeworkintroductionGreaterThan(String value) {
            addCriterion("homeworkIntroduction >", value, "homeworkintroduction");
            return (Criteria) this;
        }

        public Criteria andHomeworkintroductionGreaterThanOrEqualTo(String value) {
            addCriterion("homeworkIntroduction >=", value, "homeworkintroduction");
            return (Criteria) this;
        }

        public Criteria andHomeworkintroductionLessThan(String value) {
            addCriterion("homeworkIntroduction <", value, "homeworkintroduction");
            return (Criteria) this;
        }

        public Criteria andHomeworkintroductionLessThanOrEqualTo(String value) {
            addCriterion("homeworkIntroduction <=", value, "homeworkintroduction");
            return (Criteria) this;
        }

        public Criteria andHomeworkintroductionLike(String value) {
            addCriterion("homeworkIntroduction like", value, "homeworkintroduction");
            return (Criteria) this;
        }

        public Criteria andHomeworkintroductionNotLike(String value) {
            addCriterion("homeworkIntroduction not like", value, "homeworkintroduction");
            return (Criteria) this;
        }

        public Criteria andHomeworkintroductionIn(List<String> values) {
            addCriterion("homeworkIntroduction in", values, "homeworkintroduction");
            return (Criteria) this;
        }

        public Criteria andHomeworkintroductionNotIn(List<String> values) {
            addCriterion("homeworkIntroduction not in", values, "homeworkintroduction");
            return (Criteria) this;
        }

        public Criteria andHomeworkintroductionBetween(String value1, String value2) {
            addCriterion("homeworkIntroduction between", value1, value2, "homeworkintroduction");
            return (Criteria) this;
        }

        public Criteria andHomeworkintroductionNotBetween(String value1, String value2) {
            addCriterion("homeworkIntroduction not between", value1, value2, "homeworkintroduction");
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