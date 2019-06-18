package com.neuedu.JiemoTest.entity;

import java.util.ArrayList;
import java.util.List;

public class Answer_infoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public Answer_infoExample() {
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

        public Criteria andQuestionidIsNull() {
            addCriterion("questionId is null");
            return (Criteria) this;
        }

        public Criteria andQuestionidIsNotNull() {
            addCriterion("questionId is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionidEqualTo(Integer value) {
            addCriterion("questionId =", value, "questionid");
            return (Criteria) this;
        }

        public Criteria andQuestionidNotEqualTo(Integer value) {
            addCriterion("questionId <>", value, "questionid");
            return (Criteria) this;
        }

        public Criteria andQuestionidGreaterThan(Integer value) {
            addCriterion("questionId >", value, "questionid");
            return (Criteria) this;
        }

        public Criteria andQuestionidGreaterThanOrEqualTo(Integer value) {
            addCriterion("questionId >=", value, "questionid");
            return (Criteria) this;
        }

        public Criteria andQuestionidLessThan(Integer value) {
            addCriterion("questionId <", value, "questionid");
            return (Criteria) this;
        }

        public Criteria andQuestionidLessThanOrEqualTo(Integer value) {
            addCriterion("questionId <=", value, "questionid");
            return (Criteria) this;
        }

        public Criteria andQuestionidIn(List<Integer> values) {
            addCriterion("questionId in", values, "questionid");
            return (Criteria) this;
        }

        public Criteria andQuestionidNotIn(List<Integer> values) {
            addCriterion("questionId not in", values, "questionid");
            return (Criteria) this;
        }

        public Criteria andQuestionidBetween(Integer value1, Integer value2) {
            addCriterion("questionId between", value1, value2, "questionid");
            return (Criteria) this;
        }

        public Criteria andQuestionidNotBetween(Integer value1, Integer value2) {
            addCriterion("questionId not between", value1, value2, "questionid");
            return (Criteria) this;
        }

        public Criteria andQuestionserialnumIsNull() {
            addCriterion("questionSerialNum is null");
            return (Criteria) this;
        }

        public Criteria andQuestionserialnumIsNotNull() {
            addCriterion("questionSerialNum is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionserialnumEqualTo(Integer value) {
            addCriterion("questionSerialNum =", value, "questionserialnum");
            return (Criteria) this;
        }

        public Criteria andQuestionserialnumNotEqualTo(Integer value) {
            addCriterion("questionSerialNum <>", value, "questionserialnum");
            return (Criteria) this;
        }

        public Criteria andQuestionserialnumGreaterThan(Integer value) {
            addCriterion("questionSerialNum >", value, "questionserialnum");
            return (Criteria) this;
        }

        public Criteria andQuestionserialnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("questionSerialNum >=", value, "questionserialnum");
            return (Criteria) this;
        }

        public Criteria andQuestionserialnumLessThan(Integer value) {
            addCriterion("questionSerialNum <", value, "questionserialnum");
            return (Criteria) this;
        }

        public Criteria andQuestionserialnumLessThanOrEqualTo(Integer value) {
            addCriterion("questionSerialNum <=", value, "questionserialnum");
            return (Criteria) this;
        }

        public Criteria andQuestionserialnumIn(List<Integer> values) {
            addCriterion("questionSerialNum in", values, "questionserialnum");
            return (Criteria) this;
        }

        public Criteria andQuestionserialnumNotIn(List<Integer> values) {
            addCriterion("questionSerialNum not in", values, "questionserialnum");
            return (Criteria) this;
        }

        public Criteria andQuestionserialnumBetween(Integer value1, Integer value2) {
            addCriterion("questionSerialNum between", value1, value2, "questionserialnum");
            return (Criteria) this;
        }

        public Criteria andQuestionserialnumNotBetween(Integer value1, Integer value2) {
            addCriterion("questionSerialNum not between", value1, value2, "questionserialnum");
            return (Criteria) this;
        }

        public Criteria andAnswercontentIsNull() {
            addCriterion("answerContent is null");
            return (Criteria) this;
        }

        public Criteria andAnswercontentIsNotNull() {
            addCriterion("answerContent is not null");
            return (Criteria) this;
        }

        public Criteria andAnswercontentEqualTo(String value) {
            addCriterion("answerContent =", value, "answercontent");
            return (Criteria) this;
        }

        public Criteria andAnswercontentNotEqualTo(String value) {
            addCriterion("answerContent <>", value, "answercontent");
            return (Criteria) this;
        }

        public Criteria andAnswercontentGreaterThan(String value) {
            addCriterion("answerContent >", value, "answercontent");
            return (Criteria) this;
        }

        public Criteria andAnswercontentGreaterThanOrEqualTo(String value) {
            addCriterion("answerContent >=", value, "answercontent");
            return (Criteria) this;
        }

        public Criteria andAnswercontentLessThan(String value) {
            addCriterion("answerContent <", value, "answercontent");
            return (Criteria) this;
        }

        public Criteria andAnswercontentLessThanOrEqualTo(String value) {
            addCriterion("answerContent <=", value, "answercontent");
            return (Criteria) this;
        }

        public Criteria andAnswercontentLike(String value) {
            addCriterion("answerContent like", value, "answercontent");
            return (Criteria) this;
        }

        public Criteria andAnswercontentNotLike(String value) {
            addCriterion("answerContent not like", value, "answercontent");
            return (Criteria) this;
        }

        public Criteria andAnswercontentIn(List<String> values) {
            addCriterion("answerContent in", values, "answercontent");
            return (Criteria) this;
        }

        public Criteria andAnswercontentNotIn(List<String> values) {
            addCriterion("answerContent not in", values, "answercontent");
            return (Criteria) this;
        }

        public Criteria andAnswercontentBetween(String value1, String value2) {
            addCriterion("answerContent between", value1, value2, "answercontent");
            return (Criteria) this;
        }

        public Criteria andAnswercontentNotBetween(String value1, String value2) {
            addCriterion("answerContent not between", value1, value2, "answercontent");
            return (Criteria) this;
        }

        public Criteria andScoreIsNull() {
            addCriterion("score is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("score is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(Integer value) {
            addCriterion("score =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(Integer value) {
            addCriterion("score <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(Integer value) {
            addCriterion("score >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("score >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(Integer value) {
            addCriterion("score <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(Integer value) {
            addCriterion("score <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<Integer> values) {
            addCriterion("score in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<Integer> values) {
            addCriterion("score not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(Integer value1, Integer value2) {
            addCriterion("score between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("score not between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andCorrectstateIsNull() {
            addCriterion("correctState is null");
            return (Criteria) this;
        }

        public Criteria andCorrectstateIsNotNull() {
            addCriterion("correctState is not null");
            return (Criteria) this;
        }

        public Criteria andCorrectstateEqualTo(Integer value) {
            addCriterion("correctState =", value, "correctstate");
            return (Criteria) this;
        }

        public Criteria andCorrectstateNotEqualTo(Integer value) {
            addCriterion("correctState <>", value, "correctstate");
            return (Criteria) this;
        }

        public Criteria andCorrectstateGreaterThan(Integer value) {
            addCriterion("correctState >", value, "correctstate");
            return (Criteria) this;
        }

        public Criteria andCorrectstateGreaterThanOrEqualTo(Integer value) {
            addCriterion("correctState >=", value, "correctstate");
            return (Criteria) this;
        }

        public Criteria andCorrectstateLessThan(Integer value) {
            addCriterion("correctState <", value, "correctstate");
            return (Criteria) this;
        }

        public Criteria andCorrectstateLessThanOrEqualTo(Integer value) {
            addCriterion("correctState <=", value, "correctstate");
            return (Criteria) this;
        }

        public Criteria andCorrectstateIn(List<Integer> values) {
            addCriterion("correctState in", values, "correctstate");
            return (Criteria) this;
        }

        public Criteria andCorrectstateNotIn(List<Integer> values) {
            addCriterion("correctState not in", values, "correctstate");
            return (Criteria) this;
        }

        public Criteria andCorrectstateBetween(Integer value1, Integer value2) {
            addCriterion("correctState between", value1, value2, "correctstate");
            return (Criteria) this;
        }

        public Criteria andCorrectstateNotBetween(Integer value1, Integer value2) {
            addCriterion("correctState not between", value1, value2, "correctstate");
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