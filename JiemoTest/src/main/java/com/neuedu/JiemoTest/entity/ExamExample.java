package com.neuedu.JiemoTest.entity;

import java.util.ArrayList;
import java.util.List;

public class ExamExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ExamExample() {
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

        public Criteria andSourceexamidIsNull() {
            addCriterion("sourceExamId is null");
            return (Criteria) this;
        }

        public Criteria andSourceexamidIsNotNull() {
            addCriterion("sourceExamId is not null");
            return (Criteria) this;
        }

        public Criteria andSourceexamidEqualTo(Integer value) {
            addCriterion("sourceExamId =", value, "sourceexamid");
            return (Criteria) this;
        }

        public Criteria andSourceexamidNotEqualTo(Integer value) {
            addCriterion("sourceExamId <>", value, "sourceexamid");
            return (Criteria) this;
        }

        public Criteria andSourceexamidGreaterThan(Integer value) {
            addCriterion("sourceExamId >", value, "sourceexamid");
            return (Criteria) this;
        }

        public Criteria andSourceexamidGreaterThanOrEqualTo(Integer value) {
            addCriterion("sourceExamId >=", value, "sourceexamid");
            return (Criteria) this;
        }

        public Criteria andSourceexamidLessThan(Integer value) {
            addCriterion("sourceExamId <", value, "sourceexamid");
            return (Criteria) this;
        }

        public Criteria andSourceexamidLessThanOrEqualTo(Integer value) {
            addCriterion("sourceExamId <=", value, "sourceexamid");
            return (Criteria) this;
        }

        public Criteria andSourceexamidIn(List<Integer> values) {
            addCriterion("sourceExamId in", values, "sourceexamid");
            return (Criteria) this;
        }

        public Criteria andSourceexamidNotIn(List<Integer> values) {
            addCriterion("sourceExamId not in", values, "sourceexamid");
            return (Criteria) this;
        }

        public Criteria andSourceexamidBetween(Integer value1, Integer value2) {
            addCriterion("sourceExamId between", value1, value2, "sourceexamid");
            return (Criteria) this;
        }

        public Criteria andSourceexamidNotBetween(Integer value1, Integer value2) {
            addCriterion("sourceExamId not between", value1, value2, "sourceexamid");
            return (Criteria) this;
        }

        public Criteria andEdittimeIsNull() {
            addCriterion("editTime is null");
            return (Criteria) this;
        }

        public Criteria andEdittimeIsNotNull() {
            addCriterion("editTime is not null");
            return (Criteria) this;
        }

        public Criteria andEdittimeEqualTo(Integer value) {
            addCriterion("editTime =", value, "edittime");
            return (Criteria) this;
        }

        public Criteria andEdittimeNotEqualTo(Integer value) {
            addCriterion("editTime <>", value, "edittime");
            return (Criteria) this;
        }

        public Criteria andEdittimeGreaterThan(Integer value) {
            addCriterion("editTime >", value, "edittime");
            return (Criteria) this;
        }

        public Criteria andEdittimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("editTime >=", value, "edittime");
            return (Criteria) this;
        }

        public Criteria andEdittimeLessThan(Integer value) {
            addCriterion("editTime <", value, "edittime");
            return (Criteria) this;
        }

        public Criteria andEdittimeLessThanOrEqualTo(Integer value) {
            addCriterion("editTime <=", value, "edittime");
            return (Criteria) this;
        }

        public Criteria andEdittimeIn(List<Integer> values) {
            addCriterion("editTime in", values, "edittime");
            return (Criteria) this;
        }

        public Criteria andEdittimeNotIn(List<Integer> values) {
            addCriterion("editTime not in", values, "edittime");
            return (Criteria) this;
        }

        public Criteria andEdittimeBetween(Integer value1, Integer value2) {
            addCriterion("editTime between", value1, value2, "edittime");
            return (Criteria) this;
        }

        public Criteria andEdittimeNotBetween(Integer value1, Integer value2) {
            addCriterion("editTime not between", value1, value2, "edittime");
            return (Criteria) this;
        }

        public Criteria andStarttimeIsNull() {
            addCriterion("startTime is null");
            return (Criteria) this;
        }

        public Criteria andStarttimeIsNotNull() {
            addCriterion("startTime is not null");
            return (Criteria) this;
        }

        public Criteria andStarttimeEqualTo(Integer value) {
            addCriterion("startTime =", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotEqualTo(Integer value) {
            addCriterion("startTime <>", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThan(Integer value) {
            addCriterion("startTime >", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("startTime >=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThan(Integer value) {
            addCriterion("startTime <", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThanOrEqualTo(Integer value) {
            addCriterion("startTime <=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeIn(List<Integer> values) {
            addCriterion("startTime in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotIn(List<Integer> values) {
            addCriterion("startTime not in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeBetween(Integer value1, Integer value2) {
            addCriterion("startTime between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotBetween(Integer value1, Integer value2) {
            addCriterion("startTime not between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNull() {
            addCriterion("endTime is null");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNotNull() {
            addCriterion("endTime is not null");
            return (Criteria) this;
        }

        public Criteria andEndtimeEqualTo(Integer value) {
            addCriterion("endTime =", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotEqualTo(Integer value) {
            addCriterion("endTime <>", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThan(Integer value) {
            addCriterion("endTime >", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("endTime >=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThan(Integer value) {
            addCriterion("endTime <", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThanOrEqualTo(Integer value) {
            addCriterion("endTime <=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIn(List<Integer> values) {
            addCriterion("endTime in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotIn(List<Integer> values) {
            addCriterion("endTime not in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeBetween(Integer value1, Integer value2) {
            addCriterion("endTime between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotBetween(Integer value1, Integer value2) {
            addCriterion("endTime not between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andDurationIsNull() {
            addCriterion("duration is null");
            return (Criteria) this;
        }

        public Criteria andDurationIsNotNull() {
            addCriterion("duration is not null");
            return (Criteria) this;
        }

        public Criteria andDurationEqualTo(Integer value) {
            addCriterion("duration =", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotEqualTo(Integer value) {
            addCriterion("duration <>", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationGreaterThan(Integer value) {
            addCriterion("duration >", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationGreaterThanOrEqualTo(Integer value) {
            addCriterion("duration >=", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationLessThan(Integer value) {
            addCriterion("duration <", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationLessThanOrEqualTo(Integer value) {
            addCriterion("duration <=", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationIn(List<Integer> values) {
            addCriterion("duration in", values, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotIn(List<Integer> values) {
            addCriterion("duration not in", values, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationBetween(Integer value1, Integer value2) {
            addCriterion("duration between", value1, value2, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotBetween(Integer value1, Integer value2) {
            addCriterion("duration not between", value1, value2, "duration");
            return (Criteria) this;
        }

        public Criteria andMaxtimesIsNull() {
            addCriterion("maxTimes is null");
            return (Criteria) this;
        }

        public Criteria andMaxtimesIsNotNull() {
            addCriterion("maxTimes is not null");
            return (Criteria) this;
        }

        public Criteria andMaxtimesEqualTo(Integer value) {
            addCriterion("maxTimes =", value, "maxtimes");
            return (Criteria) this;
        }

        public Criteria andMaxtimesNotEqualTo(Integer value) {
            addCriterion("maxTimes <>", value, "maxtimes");
            return (Criteria) this;
        }

        public Criteria andMaxtimesGreaterThan(Integer value) {
            addCriterion("maxTimes >", value, "maxtimes");
            return (Criteria) this;
        }

        public Criteria andMaxtimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("maxTimes >=", value, "maxtimes");
            return (Criteria) this;
        }

        public Criteria andMaxtimesLessThan(Integer value) {
            addCriterion("maxTimes <", value, "maxtimes");
            return (Criteria) this;
        }

        public Criteria andMaxtimesLessThanOrEqualTo(Integer value) {
            addCriterion("maxTimes <=", value, "maxtimes");
            return (Criteria) this;
        }

        public Criteria andMaxtimesIn(List<Integer> values) {
            addCriterion("maxTimes in", values, "maxtimes");
            return (Criteria) this;
        }

        public Criteria andMaxtimesNotIn(List<Integer> values) {
            addCriterion("maxTimes not in", values, "maxtimes");
            return (Criteria) this;
        }

        public Criteria andMaxtimesBetween(Integer value1, Integer value2) {
            addCriterion("maxTimes between", value1, value2, "maxtimes");
            return (Criteria) this;
        }

        public Criteria andMaxtimesNotBetween(Integer value1, Integer value2) {
            addCriterion("maxTimes not between", value1, value2, "maxtimes");
            return (Criteria) this;
        }

        public Criteria andQuestionnumIsNull() {
            addCriterion("questionNum is null");
            return (Criteria) this;
        }

        public Criteria andQuestionnumIsNotNull() {
            addCriterion("questionNum is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionnumEqualTo(Integer value) {
            addCriterion("questionNum =", value, "questionnum");
            return (Criteria) this;
        }

        public Criteria andQuestionnumNotEqualTo(Integer value) {
            addCriterion("questionNum <>", value, "questionnum");
            return (Criteria) this;
        }

        public Criteria andQuestionnumGreaterThan(Integer value) {
            addCriterion("questionNum >", value, "questionnum");
            return (Criteria) this;
        }

        public Criteria andQuestionnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("questionNum >=", value, "questionnum");
            return (Criteria) this;
        }

        public Criteria andQuestionnumLessThan(Integer value) {
            addCriterion("questionNum <", value, "questionnum");
            return (Criteria) this;
        }

        public Criteria andQuestionnumLessThanOrEqualTo(Integer value) {
            addCriterion("questionNum <=", value, "questionnum");
            return (Criteria) this;
        }

        public Criteria andQuestionnumIn(List<Integer> values) {
            addCriterion("questionNum in", values, "questionnum");
            return (Criteria) this;
        }

        public Criteria andQuestionnumNotIn(List<Integer> values) {
            addCriterion("questionNum not in", values, "questionnum");
            return (Criteria) this;
        }

        public Criteria andQuestionnumBetween(Integer value1, Integer value2) {
            addCriterion("questionNum between", value1, value2, "questionnum");
            return (Criteria) this;
        }

        public Criteria andQuestionnumNotBetween(Integer value1, Integer value2) {
            addCriterion("questionNum not between", value1, value2, "questionnum");
            return (Criteria) this;
        }

        public Criteria andPointssumIsNull() {
            addCriterion("pointsSum is null");
            return (Criteria) this;
        }

        public Criteria andPointssumIsNotNull() {
            addCriterion("pointsSum is not null");
            return (Criteria) this;
        }

        public Criteria andPointssumEqualTo(Integer value) {
            addCriterion("pointsSum =", value, "pointssum");
            return (Criteria) this;
        }

        public Criteria andPointssumNotEqualTo(Integer value) {
            addCriterion("pointsSum <>", value, "pointssum");
            return (Criteria) this;
        }

        public Criteria andPointssumGreaterThan(Integer value) {
            addCriterion("pointsSum >", value, "pointssum");
            return (Criteria) this;
        }

        public Criteria andPointssumGreaterThanOrEqualTo(Integer value) {
            addCriterion("pointsSum >=", value, "pointssum");
            return (Criteria) this;
        }

        public Criteria andPointssumLessThan(Integer value) {
            addCriterion("pointsSum <", value, "pointssum");
            return (Criteria) this;
        }

        public Criteria andPointssumLessThanOrEqualTo(Integer value) {
            addCriterion("pointsSum <=", value, "pointssum");
            return (Criteria) this;
        }

        public Criteria andPointssumIn(List<Integer> values) {
            addCriterion("pointsSum in", values, "pointssum");
            return (Criteria) this;
        }

        public Criteria andPointssumNotIn(List<Integer> values) {
            addCriterion("pointsSum not in", values, "pointssum");
            return (Criteria) this;
        }

        public Criteria andPointssumBetween(Integer value1, Integer value2) {
            addCriterion("pointsSum between", value1, value2, "pointssum");
            return (Criteria) this;
        }

        public Criteria andPointssumNotBetween(Integer value1, Integer value2) {
            addCriterion("pointsSum not between", value1, value2, "pointssum");
            return (Criteria) this;
        }

        public Criteria andExamstateIsNull() {
            addCriterion("examState is null");
            return (Criteria) this;
        }

        public Criteria andExamstateIsNotNull() {
            addCriterion("examState is not null");
            return (Criteria) this;
        }

        public Criteria andExamstateEqualTo(Integer value) {
            addCriterion("examState =", value, "examstate");
            return (Criteria) this;
        }

        public Criteria andExamstateNotEqualTo(Integer value) {
            addCriterion("examState <>", value, "examstate");
            return (Criteria) this;
        }

        public Criteria andExamstateGreaterThan(Integer value) {
            addCriterion("examState >", value, "examstate");
            return (Criteria) this;
        }

        public Criteria andExamstateGreaterThanOrEqualTo(Integer value) {
            addCriterion("examState >=", value, "examstate");
            return (Criteria) this;
        }

        public Criteria andExamstateLessThan(Integer value) {
            addCriterion("examState <", value, "examstate");
            return (Criteria) this;
        }

        public Criteria andExamstateLessThanOrEqualTo(Integer value) {
            addCriterion("examState <=", value, "examstate");
            return (Criteria) this;
        }

        public Criteria andExamstateIn(List<Integer> values) {
            addCriterion("examState in", values, "examstate");
            return (Criteria) this;
        }

        public Criteria andExamstateNotIn(List<Integer> values) {
            addCriterion("examState not in", values, "examstate");
            return (Criteria) this;
        }

        public Criteria andExamstateBetween(Integer value1, Integer value2) {
            addCriterion("examState between", value1, value2, "examstate");
            return (Criteria) this;
        }

        public Criteria andExamstateNotBetween(Integer value1, Integer value2) {
            addCriterion("examState not between", value1, value2, "examstate");
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