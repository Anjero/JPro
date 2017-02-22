package net.anjero.pro.module.system.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int limitEnd = -1;

    public SysLogExample() {
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

    public void setLimitStart(int limitStart) {
        this.limitStart=limitStart;
    }

    public int getLimitStart() {
        return limitStart;
    }

    public void setLimitEnd(int limitEnd) {
        this.limitEnd=limitEnd;
    }

    public int getLimitEnd() {
        return limitEnd;
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTrackIdIsNull() {
            addCriterion("track_id is null");
            return (Criteria) this;
        }

        public Criteria andTrackIdIsNotNull() {
            addCriterion("track_id is not null");
            return (Criteria) this;
        }

        public Criteria andTrackIdEqualTo(String value) {
            addCriterion("track_id =", value, "trackId");
            return (Criteria) this;
        }

        public Criteria andTrackIdNotEqualTo(String value) {
            addCriterion("track_id <>", value, "trackId");
            return (Criteria) this;
        }

        public Criteria andTrackIdGreaterThan(String value) {
            addCriterion("track_id >", value, "trackId");
            return (Criteria) this;
        }

        public Criteria andTrackIdGreaterThanOrEqualTo(String value) {
            addCriterion("track_id >=", value, "trackId");
            return (Criteria) this;
        }

        public Criteria andTrackIdLessThan(String value) {
            addCriterion("track_id <", value, "trackId");
            return (Criteria) this;
        }

        public Criteria andTrackIdLessThanOrEqualTo(String value) {
            addCriterion("track_id <=", value, "trackId");
            return (Criteria) this;
        }

        public Criteria andTrackIdLike(String value) {
            addCriterion("track_id like", value, "trackId");
            return (Criteria) this;
        }

        public Criteria andTrackIdNotLike(String value) {
            addCriterion("track_id not like", value, "trackId");
            return (Criteria) this;
        }

        public Criteria andTrackIdIn(List<String> values) {
            addCriterion("track_id in", values, "trackId");
            return (Criteria) this;
        }

        public Criteria andTrackIdNotIn(List<String> values) {
            addCriterion("track_id not in", values, "trackId");
            return (Criteria) this;
        }

        public Criteria andTrackIdBetween(String value1, String value2) {
            addCriterion("track_id between", value1, value2, "trackId");
            return (Criteria) this;
        }

        public Criteria andTrackIdNotBetween(String value1, String value2) {
            addCriterion("track_id not between", value1, value2, "trackId");
            return (Criteria) this;
        }

        public Criteria andBroswerIsNull() {
            addCriterion("broswer is null");
            return (Criteria) this;
        }

        public Criteria andBroswerIsNotNull() {
            addCriterion("broswer is not null");
            return (Criteria) this;
        }

        public Criteria andBroswerEqualTo(String value) {
            addCriterion("broswer =", value, "broswer");
            return (Criteria) this;
        }

        public Criteria andBroswerNotEqualTo(String value) {
            addCriterion("broswer <>", value, "broswer");
            return (Criteria) this;
        }

        public Criteria andBroswerGreaterThan(String value) {
            addCriterion("broswer >", value, "broswer");
            return (Criteria) this;
        }

        public Criteria andBroswerGreaterThanOrEqualTo(String value) {
            addCriterion("broswer >=", value, "broswer");
            return (Criteria) this;
        }

        public Criteria andBroswerLessThan(String value) {
            addCriterion("broswer <", value, "broswer");
            return (Criteria) this;
        }

        public Criteria andBroswerLessThanOrEqualTo(String value) {
            addCriterion("broswer <=", value, "broswer");
            return (Criteria) this;
        }

        public Criteria andBroswerLike(String value) {
            addCriterion("broswer like", value, "broswer");
            return (Criteria) this;
        }

        public Criteria andBroswerNotLike(String value) {
            addCriterion("broswer not like", value, "broswer");
            return (Criteria) this;
        }

        public Criteria andBroswerIn(List<String> values) {
            addCriterion("broswer in", values, "broswer");
            return (Criteria) this;
        }

        public Criteria andBroswerNotIn(List<String> values) {
            addCriterion("broswer not in", values, "broswer");
            return (Criteria) this;
        }

        public Criteria andBroswerBetween(String value1, String value2) {
            addCriterion("broswer between", value1, value2, "broswer");
            return (Criteria) this;
        }

        public Criteria andBroswerNotBetween(String value1, String value2) {
            addCriterion("broswer not between", value1, value2, "broswer");
            return (Criteria) this;
        }

        public Criteria andLogcontentIsNull() {
            addCriterion("logcontent is null");
            return (Criteria) this;
        }

        public Criteria andLogcontentIsNotNull() {
            addCriterion("logcontent is not null");
            return (Criteria) this;
        }

        public Criteria andLogcontentEqualTo(String value) {
            addCriterion("logcontent =", value, "logcontent");
            return (Criteria) this;
        }

        public Criteria andLogcontentNotEqualTo(String value) {
            addCriterion("logcontent <>", value, "logcontent");
            return (Criteria) this;
        }

        public Criteria andLogcontentGreaterThan(String value) {
            addCriterion("logcontent >", value, "logcontent");
            return (Criteria) this;
        }

        public Criteria andLogcontentGreaterThanOrEqualTo(String value) {
            addCriterion("logcontent >=", value, "logcontent");
            return (Criteria) this;
        }

        public Criteria andLogcontentLessThan(String value) {
            addCriterion("logcontent <", value, "logcontent");
            return (Criteria) this;
        }

        public Criteria andLogcontentLessThanOrEqualTo(String value) {
            addCriterion("logcontent <=", value, "logcontent");
            return (Criteria) this;
        }

        public Criteria andLogcontentLike(String value) {
            addCriterion("logcontent like", value, "logcontent");
            return (Criteria) this;
        }

        public Criteria andLogcontentNotLike(String value) {
            addCriterion("logcontent not like", value, "logcontent");
            return (Criteria) this;
        }

        public Criteria andLogcontentIn(List<String> values) {
            addCriterion("logcontent in", values, "logcontent");
            return (Criteria) this;
        }

        public Criteria andLogcontentNotIn(List<String> values) {
            addCriterion("logcontent not in", values, "logcontent");
            return (Criteria) this;
        }

        public Criteria andLogcontentBetween(String value1, String value2) {
            addCriterion("logcontent between", value1, value2, "logcontent");
            return (Criteria) this;
        }

        public Criteria andLogcontentNotBetween(String value1, String value2) {
            addCriterion("logcontent not between", value1, value2, "logcontent");
            return (Criteria) this;
        }

        public Criteria andLoglevelIsNull() {
            addCriterion("loglevel is null");
            return (Criteria) this;
        }

        public Criteria andLoglevelIsNotNull() {
            addCriterion("loglevel is not null");
            return (Criteria) this;
        }

        public Criteria andLoglevelEqualTo(Integer value) {
            addCriterion("loglevel =", value, "loglevel");
            return (Criteria) this;
        }

        public Criteria andLoglevelNotEqualTo(Integer value) {
            addCriterion("loglevel <>", value, "loglevel");
            return (Criteria) this;
        }

        public Criteria andLoglevelGreaterThan(Integer value) {
            addCriterion("loglevel >", value, "loglevel");
            return (Criteria) this;
        }

        public Criteria andLoglevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("loglevel >=", value, "loglevel");
            return (Criteria) this;
        }

        public Criteria andLoglevelLessThan(Integer value) {
            addCriterion("loglevel <", value, "loglevel");
            return (Criteria) this;
        }

        public Criteria andLoglevelLessThanOrEqualTo(Integer value) {
            addCriterion("loglevel <=", value, "loglevel");
            return (Criteria) this;
        }

        public Criteria andLoglevelIn(List<Integer> values) {
            addCriterion("loglevel in", values, "loglevel");
            return (Criteria) this;
        }

        public Criteria andLoglevelNotIn(List<Integer> values) {
            addCriterion("loglevel not in", values, "loglevel");
            return (Criteria) this;
        }

        public Criteria andLoglevelBetween(Integer value1, Integer value2) {
            addCriterion("loglevel between", value1, value2, "loglevel");
            return (Criteria) this;
        }

        public Criteria andLoglevelNotBetween(Integer value1, Integer value2) {
            addCriterion("loglevel not between", value1, value2, "loglevel");
            return (Criteria) this;
        }

        public Criteria andOperateipIsNull() {
            addCriterion("operateip is null");
            return (Criteria) this;
        }

        public Criteria andOperateipIsNotNull() {
            addCriterion("operateip is not null");
            return (Criteria) this;
        }

        public Criteria andOperateipEqualTo(String value) {
            addCriterion("operateip =", value, "operateip");
            return (Criteria) this;
        }

        public Criteria andOperateipNotEqualTo(String value) {
            addCriterion("operateip <>", value, "operateip");
            return (Criteria) this;
        }

        public Criteria andOperateipGreaterThan(String value) {
            addCriterion("operateip >", value, "operateip");
            return (Criteria) this;
        }

        public Criteria andOperateipGreaterThanOrEqualTo(String value) {
            addCriterion("operateip >=", value, "operateip");
            return (Criteria) this;
        }

        public Criteria andOperateipLessThan(String value) {
            addCriterion("operateip <", value, "operateip");
            return (Criteria) this;
        }

        public Criteria andOperateipLessThanOrEqualTo(String value) {
            addCriterion("operateip <=", value, "operateip");
            return (Criteria) this;
        }

        public Criteria andOperateipLike(String value) {
            addCriterion("operateip like", value, "operateip");
            return (Criteria) this;
        }

        public Criteria andOperateipNotLike(String value) {
            addCriterion("operateip not like", value, "operateip");
            return (Criteria) this;
        }

        public Criteria andOperateipIn(List<String> values) {
            addCriterion("operateip in", values, "operateip");
            return (Criteria) this;
        }

        public Criteria andOperateipNotIn(List<String> values) {
            addCriterion("operateip not in", values, "operateip");
            return (Criteria) this;
        }

        public Criteria andOperateipBetween(String value1, String value2) {
            addCriterion("operateip between", value1, value2, "operateip");
            return (Criteria) this;
        }

        public Criteria andOperateipNotBetween(String value1, String value2) {
            addCriterion("operateip not between", value1, value2, "operateip");
            return (Criteria) this;
        }

        public Criteria andOperatetimeIsNull() {
            addCriterion("operatetime is null");
            return (Criteria) this;
        }

        public Criteria andOperatetimeIsNotNull() {
            addCriterion("operatetime is not null");
            return (Criteria) this;
        }

        public Criteria andOperatetimeEqualTo(Date value) {
            addCriterion("operatetime =", value, "operatetime");
            return (Criteria) this;
        }

        public Criteria andOperatetimeNotEqualTo(Date value) {
            addCriterion("operatetime <>", value, "operatetime");
            return (Criteria) this;
        }

        public Criteria andOperatetimeGreaterThan(Date value) {
            addCriterion("operatetime >", value, "operatetime");
            return (Criteria) this;
        }

        public Criteria andOperatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("operatetime >=", value, "operatetime");
            return (Criteria) this;
        }

        public Criteria andOperatetimeLessThan(Date value) {
            addCriterion("operatetime <", value, "operatetime");
            return (Criteria) this;
        }

        public Criteria andOperatetimeLessThanOrEqualTo(Date value) {
            addCriterion("operatetime <=", value, "operatetime");
            return (Criteria) this;
        }

        public Criteria andOperatetimeIn(List<Date> values) {
            addCriterion("operatetime in", values, "operatetime");
            return (Criteria) this;
        }

        public Criteria andOperatetimeNotIn(List<Date> values) {
            addCriterion("operatetime not in", values, "operatetime");
            return (Criteria) this;
        }

        public Criteria andOperatetimeBetween(Date value1, Date value2) {
            addCriterion("operatetime between", value1, value2, "operatetime");
            return (Criteria) this;
        }

        public Criteria andOperatetimeNotBetween(Date value1, Date value2) {
            addCriterion("operatetime not between", value1, value2, "operatetime");
            return (Criteria) this;
        }

        public Criteria andOperatetypeIsNull() {
            addCriterion("operatetype is null");
            return (Criteria) this;
        }

        public Criteria andOperatetypeIsNotNull() {
            addCriterion("operatetype is not null");
            return (Criteria) this;
        }

        public Criteria andOperatetypeEqualTo(Integer value) {
            addCriterion("operatetype =", value, "operatetype");
            return (Criteria) this;
        }

        public Criteria andOperatetypeNotEqualTo(Integer value) {
            addCriterion("operatetype <>", value, "operatetype");
            return (Criteria) this;
        }

        public Criteria andOperatetypeGreaterThan(Integer value) {
            addCriterion("operatetype >", value, "operatetype");
            return (Criteria) this;
        }

        public Criteria andOperatetypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("operatetype >=", value, "operatetype");
            return (Criteria) this;
        }

        public Criteria andOperatetypeLessThan(Integer value) {
            addCriterion("operatetype <", value, "operatetype");
            return (Criteria) this;
        }

        public Criteria andOperatetypeLessThanOrEqualTo(Integer value) {
            addCriterion("operatetype <=", value, "operatetype");
            return (Criteria) this;
        }

        public Criteria andOperatetypeIn(List<Integer> values) {
            addCriterion("operatetype in", values, "operatetype");
            return (Criteria) this;
        }

        public Criteria andOperatetypeNotIn(List<Integer> values) {
            addCriterion("operatetype not in", values, "operatetype");
            return (Criteria) this;
        }

        public Criteria andOperatetypeBetween(Integer value1, Integer value2) {
            addCriterion("operatetype between", value1, value2, "operatetype");
            return (Criteria) this;
        }

        public Criteria andOperatetypeNotBetween(Integer value1, Integer value2) {
            addCriterion("operatetype not between", value1, value2, "operatetype");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userid is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Integer value) {
            addCriterion("userid =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Integer value) {
            addCriterion("userid <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Integer value) {
            addCriterion("userid >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("userid >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Integer value) {
            addCriterion("userid <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Integer value) {
            addCriterion("userid <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Integer> values) {
            addCriterion("userid in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Integer> values) {
            addCriterion("userid not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Integer value1, Integer value2) {
            addCriterion("userid between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("userid not between", value1, value2, "userid");
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