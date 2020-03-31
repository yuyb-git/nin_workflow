/*
 * FormLeaveExample.java
 * Copyright(c) 2017-2018 厦门网中网软件有限公司
 * All right reserved.
 * 2020-03-31 Created
 */
package cn.netinnet.workflow.activiti.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FormLeaveExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FormLeaveExample() {
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

    /**
     * @author admin
     * @date   2020-03-31
     */
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

        public Criteria andFormIdIsNull() {
            addCriterion("form_id is null");
            return (Criteria) this;
        }

        public Criteria andFormIdIsNotNull() {
            addCriterion("form_id is not null");
            return (Criteria) this;
        }

        public Criteria andFormIdEqualTo(Long value) {
            addCriterion("form_id =", value, "formId");
            return (Criteria) this;
        }

        public Criteria andFormIdNotEqualTo(Long value) {
            addCriterion("form_id <>", value, "formId");
            return (Criteria) this;
        }

        public Criteria andFormIdGreaterThan(Long value) {
            addCriterion("form_id >", value, "formId");
            return (Criteria) this;
        }

        public Criteria andFormIdGreaterThanOrEqualTo(Long value) {
            addCriterion("form_id >=", value, "formId");
            return (Criteria) this;
        }

        public Criteria andFormIdLessThan(Long value) {
            addCriterion("form_id <", value, "formId");
            return (Criteria) this;
        }

        public Criteria andFormIdLessThanOrEqualTo(Long value) {
            addCriterion("form_id <=", value, "formId");
            return (Criteria) this;
        }

        public Criteria andFormIdIn(List<Long> values) {
            addCriterion("form_id in", values, "formId");
            return (Criteria) this;
        }

        public Criteria andFormIdNotIn(List<Long> values) {
            addCriterion("form_id not in", values, "formId");
            return (Criteria) this;
        }

        public Criteria andFormIdBetween(Long value1, Long value2) {
            addCriterion("form_id between", value1, value2, "formId");
            return (Criteria) this;
        }

        public Criteria andFormIdNotBetween(Long value1, Long value2) {
            addCriterion("form_id not between", value1, value2, "formId");
            return (Criteria) this;
        }

        public Criteria andFormNoIsNull() {
            addCriterion("form_no is null");
            return (Criteria) this;
        }

        public Criteria andFormNoIsNotNull() {
            addCriterion("form_no is not null");
            return (Criteria) this;
        }

        public Criteria andFormNoEqualTo(Long value) {
            addCriterion("form_no =", value, "formNo");
            return (Criteria) this;
        }

        public Criteria andFormNoNotEqualTo(Long value) {
            addCriterion("form_no <>", value, "formNo");
            return (Criteria) this;
        }

        public Criteria andFormNoGreaterThan(Long value) {
            addCriterion("form_no >", value, "formNo");
            return (Criteria) this;
        }

        public Criteria andFormNoGreaterThanOrEqualTo(Long value) {
            addCriterion("form_no >=", value, "formNo");
            return (Criteria) this;
        }

        public Criteria andFormNoLessThan(Long value) {
            addCriterion("form_no <", value, "formNo");
            return (Criteria) this;
        }

        public Criteria andFormNoLessThanOrEqualTo(Long value) {
            addCriterion("form_no <=", value, "formNo");
            return (Criteria) this;
        }

        public Criteria andFormNoIn(List<Long> values) {
            addCriterion("form_no in", values, "formNo");
            return (Criteria) this;
        }

        public Criteria andFormNoNotIn(List<Long> values) {
            addCriterion("form_no not in", values, "formNo");
            return (Criteria) this;
        }

        public Criteria andFormNoBetween(Long value1, Long value2) {
            addCriterion("form_no between", value1, value2, "formNo");
            return (Criteria) this;
        }

        public Criteria andFormNoNotBetween(Long value1, Long value2) {
            addCriterion("form_no not between", value1, value2, "formNo");
            return (Criteria) this;
        }

        public Criteria andLeaverIdIsNull() {
            addCriterion("leaver_id is null");
            return (Criteria) this;
        }

        public Criteria andLeaverIdIsNotNull() {
            addCriterion("leaver_id is not null");
            return (Criteria) this;
        }

        public Criteria andLeaverIdEqualTo(Long value) {
            addCriterion("leaver_id =", value, "leaverId");
            return (Criteria) this;
        }

        public Criteria andLeaverIdNotEqualTo(Long value) {
            addCriterion("leaver_id <>", value, "leaverId");
            return (Criteria) this;
        }

        public Criteria andLeaverIdGreaterThan(Long value) {
            addCriterion("leaver_id >", value, "leaverId");
            return (Criteria) this;
        }

        public Criteria andLeaverIdGreaterThanOrEqualTo(Long value) {
            addCriterion("leaver_id >=", value, "leaverId");
            return (Criteria) this;
        }

        public Criteria andLeaverIdLessThan(Long value) {
            addCriterion("leaver_id <", value, "leaverId");
            return (Criteria) this;
        }

        public Criteria andLeaverIdLessThanOrEqualTo(Long value) {
            addCriterion("leaver_id <=", value, "leaverId");
            return (Criteria) this;
        }

        public Criteria andLeaverIdIn(List<Long> values) {
            addCriterion("leaver_id in", values, "leaverId");
            return (Criteria) this;
        }

        public Criteria andLeaverIdNotIn(List<Long> values) {
            addCriterion("leaver_id not in", values, "leaverId");
            return (Criteria) this;
        }

        public Criteria andLeaverIdBetween(Long value1, Long value2) {
            addCriterion("leaver_id between", value1, value2, "leaverId");
            return (Criteria) this;
        }

        public Criteria andLeaverIdNotBetween(Long value1, Long value2) {
            addCriterion("leaver_id not between", value1, value2, "leaverId");
            return (Criteria) this;
        }

        public Criteria andLeaverNameIsNull() {
            addCriterion("leaver_name is null");
            return (Criteria) this;
        }

        public Criteria andLeaverNameIsNotNull() {
            addCriterion("leaver_name is not null");
            return (Criteria) this;
        }

        public Criteria andLeaverNameEqualTo(String value) {
            addCriterion("leaver_name =", value, "leaverName");
            return (Criteria) this;
        }

        public Criteria andLeaverNameNotEqualTo(String value) {
            addCriterion("leaver_name <>", value, "leaverName");
            return (Criteria) this;
        }

        public Criteria andLeaverNameGreaterThan(String value) {
            addCriterion("leaver_name >", value, "leaverName");
            return (Criteria) this;
        }

        public Criteria andLeaverNameGreaterThanOrEqualTo(String value) {
            addCriterion("leaver_name >=", value, "leaverName");
            return (Criteria) this;
        }

        public Criteria andLeaverNameLessThan(String value) {
            addCriterion("leaver_name <", value, "leaverName");
            return (Criteria) this;
        }

        public Criteria andLeaverNameLessThanOrEqualTo(String value) {
            addCriterion("leaver_name <=", value, "leaverName");
            return (Criteria) this;
        }

        public Criteria andLeaverNameLike(String value) {
            addCriterion("leaver_name like", value, "leaverName");
            return (Criteria) this;
        }

        public Criteria andLeaverNameNotLike(String value) {
            addCriterion("leaver_name not like", value, "leaverName");
            return (Criteria) this;
        }

        public Criteria andLeaverNameIn(List<String> values) {
            addCriterion("leaver_name in", values, "leaverName");
            return (Criteria) this;
        }

        public Criteria andLeaverNameNotIn(List<String> values) {
            addCriterion("leaver_name not in", values, "leaverName");
            return (Criteria) this;
        }

        public Criteria andLeaverNameBetween(String value1, String value2) {
            addCriterion("leaver_name between", value1, value2, "leaverName");
            return (Criteria) this;
        }

        public Criteria andLeaverNameNotBetween(String value1, String value2) {
            addCriterion("leaver_name not between", value1, value2, "leaverName");
            return (Criteria) this;
        }

        public Criteria andLeaverDeptIdIsNull() {
            addCriterion("leaver_dept_id is null");
            return (Criteria) this;
        }

        public Criteria andLeaverDeptIdIsNotNull() {
            addCriterion("leaver_dept_id is not null");
            return (Criteria) this;
        }

        public Criteria andLeaverDeptIdEqualTo(Long value) {
            addCriterion("leaver_dept_id =", value, "leaverDeptId");
            return (Criteria) this;
        }

        public Criteria andLeaverDeptIdNotEqualTo(Long value) {
            addCriterion("leaver_dept_id <>", value, "leaverDeptId");
            return (Criteria) this;
        }

        public Criteria andLeaverDeptIdGreaterThan(Long value) {
            addCriterion("leaver_dept_id >", value, "leaverDeptId");
            return (Criteria) this;
        }

        public Criteria andLeaverDeptIdGreaterThanOrEqualTo(Long value) {
            addCriterion("leaver_dept_id >=", value, "leaverDeptId");
            return (Criteria) this;
        }

        public Criteria andLeaverDeptIdLessThan(Long value) {
            addCriterion("leaver_dept_id <", value, "leaverDeptId");
            return (Criteria) this;
        }

        public Criteria andLeaverDeptIdLessThanOrEqualTo(Long value) {
            addCriterion("leaver_dept_id <=", value, "leaverDeptId");
            return (Criteria) this;
        }

        public Criteria andLeaverDeptIdIn(List<Long> values) {
            addCriterion("leaver_dept_id in", values, "leaverDeptId");
            return (Criteria) this;
        }

        public Criteria andLeaverDeptIdNotIn(List<Long> values) {
            addCriterion("leaver_dept_id not in", values, "leaverDeptId");
            return (Criteria) this;
        }

        public Criteria andLeaverDeptIdBetween(Long value1, Long value2) {
            addCriterion("leaver_dept_id between", value1, value2, "leaverDeptId");
            return (Criteria) this;
        }

        public Criteria andLeaverDeptIdNotBetween(Long value1, Long value2) {
            addCriterion("leaver_dept_id not between", value1, value2, "leaverDeptId");
            return (Criteria) this;
        }

        public Criteria andLeaverDeptIsNull() {
            addCriterion("leaver_dept is null");
            return (Criteria) this;
        }

        public Criteria andLeaverDeptIsNotNull() {
            addCriterion("leaver_dept is not null");
            return (Criteria) this;
        }

        public Criteria andLeaverDeptEqualTo(String value) {
            addCriterion("leaver_dept =", value, "leaverDept");
            return (Criteria) this;
        }

        public Criteria andLeaverDeptNotEqualTo(String value) {
            addCriterion("leaver_dept <>", value, "leaverDept");
            return (Criteria) this;
        }

        public Criteria andLeaverDeptGreaterThan(String value) {
            addCriterion("leaver_dept >", value, "leaverDept");
            return (Criteria) this;
        }

        public Criteria andLeaverDeptGreaterThanOrEqualTo(String value) {
            addCriterion("leaver_dept >=", value, "leaverDept");
            return (Criteria) this;
        }

        public Criteria andLeaverDeptLessThan(String value) {
            addCriterion("leaver_dept <", value, "leaverDept");
            return (Criteria) this;
        }

        public Criteria andLeaverDeptLessThanOrEqualTo(String value) {
            addCriterion("leaver_dept <=", value, "leaverDept");
            return (Criteria) this;
        }

        public Criteria andLeaverDeptLike(String value) {
            addCriterion("leaver_dept like", value, "leaverDept");
            return (Criteria) this;
        }

        public Criteria andLeaverDeptNotLike(String value) {
            addCriterion("leaver_dept not like", value, "leaverDept");
            return (Criteria) this;
        }

        public Criteria andLeaverDeptIn(List<String> values) {
            addCriterion("leaver_dept in", values, "leaverDept");
            return (Criteria) this;
        }

        public Criteria andLeaverDeptNotIn(List<String> values) {
            addCriterion("leaver_dept not in", values, "leaverDept");
            return (Criteria) this;
        }

        public Criteria andLeaverDeptBetween(String value1, String value2) {
            addCriterion("leaver_dept between", value1, value2, "leaverDept");
            return (Criteria) this;
        }

        public Criteria andLeaverDeptNotBetween(String value1, String value2) {
            addCriterion("leaver_dept not between", value1, value2, "leaverDept");
            return (Criteria) this;
        }

        public Criteria andLeaveTypeIsNull() {
            addCriterion("leave_type is null");
            return (Criteria) this;
        }

        public Criteria andLeaveTypeIsNotNull() {
            addCriterion("leave_type is not null");
            return (Criteria) this;
        }

        public Criteria andLeaveTypeEqualTo(Integer value) {
            addCriterion("leave_type =", value, "leaveType");
            return (Criteria) this;
        }

        public Criteria andLeaveTypeNotEqualTo(Integer value) {
            addCriterion("leave_type <>", value, "leaveType");
            return (Criteria) this;
        }

        public Criteria andLeaveTypeGreaterThan(Integer value) {
            addCriterion("leave_type >", value, "leaveType");
            return (Criteria) this;
        }

        public Criteria andLeaveTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("leave_type >=", value, "leaveType");
            return (Criteria) this;
        }

        public Criteria andLeaveTypeLessThan(Integer value) {
            addCriterion("leave_type <", value, "leaveType");
            return (Criteria) this;
        }

        public Criteria andLeaveTypeLessThanOrEqualTo(Integer value) {
            addCriterion("leave_type <=", value, "leaveType");
            return (Criteria) this;
        }

        public Criteria andLeaveTypeIn(List<Integer> values) {
            addCriterion("leave_type in", values, "leaveType");
            return (Criteria) this;
        }

        public Criteria andLeaveTypeNotIn(List<Integer> values) {
            addCriterion("leave_type not in", values, "leaveType");
            return (Criteria) this;
        }

        public Criteria andLeaveTypeBetween(Integer value1, Integer value2) {
            addCriterion("leave_type between", value1, value2, "leaveType");
            return (Criteria) this;
        }

        public Criteria andLeaveTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("leave_type not between", value1, value2, "leaveType");
            return (Criteria) this;
        }

        public Criteria andLeaveStartIsNull() {
            addCriterion("leave_start is null");
            return (Criteria) this;
        }

        public Criteria andLeaveStartIsNotNull() {
            addCriterion("leave_start is not null");
            return (Criteria) this;
        }

        public Criteria andLeaveStartEqualTo(Date value) {
            addCriterion("leave_start =", value, "leaveStart");
            return (Criteria) this;
        }

        public Criteria andLeaveStartNotEqualTo(Date value) {
            addCriterion("leave_start <>", value, "leaveStart");
            return (Criteria) this;
        }

        public Criteria andLeaveStartGreaterThan(Date value) {
            addCriterion("leave_start >", value, "leaveStart");
            return (Criteria) this;
        }

        public Criteria andLeaveStartGreaterThanOrEqualTo(Date value) {
            addCriterion("leave_start >=", value, "leaveStart");
            return (Criteria) this;
        }

        public Criteria andLeaveStartLessThan(Date value) {
            addCriterion("leave_start <", value, "leaveStart");
            return (Criteria) this;
        }

        public Criteria andLeaveStartLessThanOrEqualTo(Date value) {
            addCriterion("leave_start <=", value, "leaveStart");
            return (Criteria) this;
        }

        public Criteria andLeaveStartIn(List<Date> values) {
            addCriterion("leave_start in", values, "leaveStart");
            return (Criteria) this;
        }

        public Criteria andLeaveStartNotIn(List<Date> values) {
            addCriterion("leave_start not in", values, "leaveStart");
            return (Criteria) this;
        }

        public Criteria andLeaveStartBetween(Date value1, Date value2) {
            addCriterion("leave_start between", value1, value2, "leaveStart");
            return (Criteria) this;
        }

        public Criteria andLeaveStartNotBetween(Date value1, Date value2) {
            addCriterion("leave_start not between", value1, value2, "leaveStart");
            return (Criteria) this;
        }

        public Criteria andLeaveEndIsNull() {
            addCriterion("leave_end is null");
            return (Criteria) this;
        }

        public Criteria andLeaveEndIsNotNull() {
            addCriterion("leave_end is not null");
            return (Criteria) this;
        }

        public Criteria andLeaveEndEqualTo(Date value) {
            addCriterion("leave_end =", value, "leaveEnd");
            return (Criteria) this;
        }

        public Criteria andLeaveEndNotEqualTo(Date value) {
            addCriterion("leave_end <>", value, "leaveEnd");
            return (Criteria) this;
        }

        public Criteria andLeaveEndGreaterThan(Date value) {
            addCriterion("leave_end >", value, "leaveEnd");
            return (Criteria) this;
        }

        public Criteria andLeaveEndGreaterThanOrEqualTo(Date value) {
            addCriterion("leave_end >=", value, "leaveEnd");
            return (Criteria) this;
        }

        public Criteria andLeaveEndLessThan(Date value) {
            addCriterion("leave_end <", value, "leaveEnd");
            return (Criteria) this;
        }

        public Criteria andLeaveEndLessThanOrEqualTo(Date value) {
            addCriterion("leave_end <=", value, "leaveEnd");
            return (Criteria) this;
        }

        public Criteria andLeaveEndIn(List<Date> values) {
            addCriterion("leave_end in", values, "leaveEnd");
            return (Criteria) this;
        }

        public Criteria andLeaveEndNotIn(List<Date> values) {
            addCriterion("leave_end not in", values, "leaveEnd");
            return (Criteria) this;
        }

        public Criteria andLeaveEndBetween(Date value1, Date value2) {
            addCriterion("leave_end between", value1, value2, "leaveEnd");
            return (Criteria) this;
        }

        public Criteria andLeaveEndNotBetween(Date value1, Date value2) {
            addCriterion("leave_end not between", value1, value2, "leaveEnd");
            return (Criteria) this;
        }

        public Criteria andLeaveDayIsNull() {
            addCriterion("leave_day is null");
            return (Criteria) this;
        }

        public Criteria andLeaveDayIsNotNull() {
            addCriterion("leave_day is not null");
            return (Criteria) this;
        }

        public Criteria andLeaveDayEqualTo(Integer value) {
            addCriterion("leave_day =", value, "leaveDay");
            return (Criteria) this;
        }

        public Criteria andLeaveDayNotEqualTo(Integer value) {
            addCriterion("leave_day <>", value, "leaveDay");
            return (Criteria) this;
        }

        public Criteria andLeaveDayGreaterThan(Integer value) {
            addCriterion("leave_day >", value, "leaveDay");
            return (Criteria) this;
        }

        public Criteria andLeaveDayGreaterThanOrEqualTo(Integer value) {
            addCriterion("leave_day >=", value, "leaveDay");
            return (Criteria) this;
        }

        public Criteria andLeaveDayLessThan(Integer value) {
            addCriterion("leave_day <", value, "leaveDay");
            return (Criteria) this;
        }

        public Criteria andLeaveDayLessThanOrEqualTo(Integer value) {
            addCriterion("leave_day <=", value, "leaveDay");
            return (Criteria) this;
        }

        public Criteria andLeaveDayIn(List<Integer> values) {
            addCriterion("leave_day in", values, "leaveDay");
            return (Criteria) this;
        }

        public Criteria andLeaveDayNotIn(List<Integer> values) {
            addCriterion("leave_day not in", values, "leaveDay");
            return (Criteria) this;
        }

        public Criteria andLeaveDayBetween(Integer value1, Integer value2) {
            addCriterion("leave_day between", value1, value2, "leaveDay");
            return (Criteria) this;
        }

        public Criteria andLeaveDayNotBetween(Integer value1, Integer value2) {
            addCriterion("leave_day not between", value1, value2, "leaveDay");
            return (Criteria) this;
        }

        public Criteria andLeaveHourIsNull() {
            addCriterion("leave_hour is null");
            return (Criteria) this;
        }

        public Criteria andLeaveHourIsNotNull() {
            addCriterion("leave_hour is not null");
            return (Criteria) this;
        }

        public Criteria andLeaveHourEqualTo(Float value) {
            addCriterion("leave_hour =", value, "leaveHour");
            return (Criteria) this;
        }

        public Criteria andLeaveHourNotEqualTo(Float value) {
            addCriterion("leave_hour <>", value, "leaveHour");
            return (Criteria) this;
        }

        public Criteria andLeaveHourGreaterThan(Float value) {
            addCriterion("leave_hour >", value, "leaveHour");
            return (Criteria) this;
        }

        public Criteria andLeaveHourGreaterThanOrEqualTo(Float value) {
            addCriterion("leave_hour >=", value, "leaveHour");
            return (Criteria) this;
        }

        public Criteria andLeaveHourLessThan(Float value) {
            addCriterion("leave_hour <", value, "leaveHour");
            return (Criteria) this;
        }

        public Criteria andLeaveHourLessThanOrEqualTo(Float value) {
            addCriterion("leave_hour <=", value, "leaveHour");
            return (Criteria) this;
        }

        public Criteria andLeaveHourIn(List<Float> values) {
            addCriterion("leave_hour in", values, "leaveHour");
            return (Criteria) this;
        }

        public Criteria andLeaveHourNotIn(List<Float> values) {
            addCriterion("leave_hour not in", values, "leaveHour");
            return (Criteria) this;
        }

        public Criteria andLeaveHourBetween(Float value1, Float value2) {
            addCriterion("leave_hour between", value1, value2, "leaveHour");
            return (Criteria) this;
        }

        public Criteria andLeaveHourNotBetween(Float value1, Float value2) {
            addCriterion("leave_hour not between", value1, value2, "leaveHour");
            return (Criteria) this;
        }

        public Criteria andApproveResultIsNull() {
            addCriterion("approve_result is null");
            return (Criteria) this;
        }

        public Criteria andApproveResultIsNotNull() {
            addCriterion("approve_result is not null");
            return (Criteria) this;
        }

        public Criteria andApproveResultEqualTo(Integer value) {
            addCriterion("approve_result =", value, "approveResult");
            return (Criteria) this;
        }

        public Criteria andApproveResultNotEqualTo(Integer value) {
            addCriterion("approve_result <>", value, "approveResult");
            return (Criteria) this;
        }

        public Criteria andApproveResultGreaterThan(Integer value) {
            addCriterion("approve_result >", value, "approveResult");
            return (Criteria) this;
        }

        public Criteria andApproveResultGreaterThanOrEqualTo(Integer value) {
            addCriterion("approve_result >=", value, "approveResult");
            return (Criteria) this;
        }

        public Criteria andApproveResultLessThan(Integer value) {
            addCriterion("approve_result <", value, "approveResult");
            return (Criteria) this;
        }

        public Criteria andApproveResultLessThanOrEqualTo(Integer value) {
            addCriterion("approve_result <=", value, "approveResult");
            return (Criteria) this;
        }

        public Criteria andApproveResultIn(List<Integer> values) {
            addCriterion("approve_result in", values, "approveResult");
            return (Criteria) this;
        }

        public Criteria andApproveResultNotIn(List<Integer> values) {
            addCriterion("approve_result not in", values, "approveResult");
            return (Criteria) this;
        }

        public Criteria andApproveResultBetween(Integer value1, Integer value2) {
            addCriterion("approve_result between", value1, value2, "approveResult");
            return (Criteria) this;
        }

        public Criteria andApproveResultNotBetween(Integer value1, Integer value2) {
            addCriterion("approve_result not between", value1, value2, "approveResult");
            return (Criteria) this;
        }

        public Criteria andReasonIsNull() {
            addCriterion("reason is null");
            return (Criteria) this;
        }

        public Criteria andReasonIsNotNull() {
            addCriterion("reason is not null");
            return (Criteria) this;
        }

        public Criteria andReasonEqualTo(String value) {
            addCriterion("reason =", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotEqualTo(String value) {
            addCriterion("reason <>", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThan(String value) {
            addCriterion("reason >", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThanOrEqualTo(String value) {
            addCriterion("reason >=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThan(String value) {
            addCriterion("reason <", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThanOrEqualTo(String value) {
            addCriterion("reason <=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLike(String value) {
            addCriterion("reason like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotLike(String value) {
            addCriterion("reason not like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonIn(List<String> values) {
            addCriterion("reason in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotIn(List<String> values) {
            addCriterion("reason not in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonBetween(String value1, String value2) {
            addCriterion("reason between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotBetween(String value1, String value2) {
            addCriterion("reason not between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andLeaderOpinionIsNull() {
            addCriterion("leader_opinion is null");
            return (Criteria) this;
        }

        public Criteria andLeaderOpinionIsNotNull() {
            addCriterion("leader_opinion is not null");
            return (Criteria) this;
        }

        public Criteria andLeaderOpinionEqualTo(String value) {
            addCriterion("leader_opinion =", value, "leaderOpinion");
            return (Criteria) this;
        }

        public Criteria andLeaderOpinionNotEqualTo(String value) {
            addCriterion("leader_opinion <>", value, "leaderOpinion");
            return (Criteria) this;
        }

        public Criteria andLeaderOpinionGreaterThan(String value) {
            addCriterion("leader_opinion >", value, "leaderOpinion");
            return (Criteria) this;
        }

        public Criteria andLeaderOpinionGreaterThanOrEqualTo(String value) {
            addCriterion("leader_opinion >=", value, "leaderOpinion");
            return (Criteria) this;
        }

        public Criteria andLeaderOpinionLessThan(String value) {
            addCriterion("leader_opinion <", value, "leaderOpinion");
            return (Criteria) this;
        }

        public Criteria andLeaderOpinionLessThanOrEqualTo(String value) {
            addCriterion("leader_opinion <=", value, "leaderOpinion");
            return (Criteria) this;
        }

        public Criteria andLeaderOpinionLike(String value) {
            addCriterion("leader_opinion like", value, "leaderOpinion");
            return (Criteria) this;
        }

        public Criteria andLeaderOpinionNotLike(String value) {
            addCriterion("leader_opinion not like", value, "leaderOpinion");
            return (Criteria) this;
        }

        public Criteria andLeaderOpinionIn(List<String> values) {
            addCriterion("leader_opinion in", values, "leaderOpinion");
            return (Criteria) this;
        }

        public Criteria andLeaderOpinionNotIn(List<String> values) {
            addCriterion("leader_opinion not in", values, "leaderOpinion");
            return (Criteria) this;
        }

        public Criteria andLeaderOpinionBetween(String value1, String value2) {
            addCriterion("leader_opinion between", value1, value2, "leaderOpinion");
            return (Criteria) this;
        }

        public Criteria andLeaderOpinionNotBetween(String value1, String value2) {
            addCriterion("leader_opinion not between", value1, value2, "leaderOpinion");
            return (Criteria) this;
        }

        public Criteria andManagerOpinionIsNull() {
            addCriterion("manager_opinion is null");
            return (Criteria) this;
        }

        public Criteria andManagerOpinionIsNotNull() {
            addCriterion("manager_opinion is not null");
            return (Criteria) this;
        }

        public Criteria andManagerOpinionEqualTo(String value) {
            addCriterion("manager_opinion =", value, "managerOpinion");
            return (Criteria) this;
        }

        public Criteria andManagerOpinionNotEqualTo(String value) {
            addCriterion("manager_opinion <>", value, "managerOpinion");
            return (Criteria) this;
        }

        public Criteria andManagerOpinionGreaterThan(String value) {
            addCriterion("manager_opinion >", value, "managerOpinion");
            return (Criteria) this;
        }

        public Criteria andManagerOpinionGreaterThanOrEqualTo(String value) {
            addCriterion("manager_opinion >=", value, "managerOpinion");
            return (Criteria) this;
        }

        public Criteria andManagerOpinionLessThan(String value) {
            addCriterion("manager_opinion <", value, "managerOpinion");
            return (Criteria) this;
        }

        public Criteria andManagerOpinionLessThanOrEqualTo(String value) {
            addCriterion("manager_opinion <=", value, "managerOpinion");
            return (Criteria) this;
        }

        public Criteria andManagerOpinionLike(String value) {
            addCriterion("manager_opinion like", value, "managerOpinion");
            return (Criteria) this;
        }

        public Criteria andManagerOpinionNotLike(String value) {
            addCriterion("manager_opinion not like", value, "managerOpinion");
            return (Criteria) this;
        }

        public Criteria andManagerOpinionIn(List<String> values) {
            addCriterion("manager_opinion in", values, "managerOpinion");
            return (Criteria) this;
        }

        public Criteria andManagerOpinionNotIn(List<String> values) {
            addCriterion("manager_opinion not in", values, "managerOpinion");
            return (Criteria) this;
        }

        public Criteria andManagerOpinionBetween(String value1, String value2) {
            addCriterion("manager_opinion between", value1, value2, "managerOpinion");
            return (Criteria) this;
        }

        public Criteria andManagerOpinionNotBetween(String value1, String value2) {
            addCriterion("manager_opinion not between", value1, value2, "managerOpinion");
            return (Criteria) this;
        }

        public Criteria andDescrIsNull() {
            addCriterion("descr is null");
            return (Criteria) this;
        }

        public Criteria andDescrIsNotNull() {
            addCriterion("descr is not null");
            return (Criteria) this;
        }

        public Criteria andDescrEqualTo(String value) {
            addCriterion("descr =", value, "descr");
            return (Criteria) this;
        }

        public Criteria andDescrNotEqualTo(String value) {
            addCriterion("descr <>", value, "descr");
            return (Criteria) this;
        }

        public Criteria andDescrGreaterThan(String value) {
            addCriterion("descr >", value, "descr");
            return (Criteria) this;
        }

        public Criteria andDescrGreaterThanOrEqualTo(String value) {
            addCriterion("descr >=", value, "descr");
            return (Criteria) this;
        }

        public Criteria andDescrLessThan(String value) {
            addCriterion("descr <", value, "descr");
            return (Criteria) this;
        }

        public Criteria andDescrLessThanOrEqualTo(String value) {
            addCriterion("descr <=", value, "descr");
            return (Criteria) this;
        }

        public Criteria andDescrLike(String value) {
            addCriterion("descr like", value, "descr");
            return (Criteria) this;
        }

        public Criteria andDescrNotLike(String value) {
            addCriterion("descr not like", value, "descr");
            return (Criteria) this;
        }

        public Criteria andDescrIn(List<String> values) {
            addCriterion("descr in", values, "descr");
            return (Criteria) this;
        }

        public Criteria andDescrNotIn(List<String> values) {
            addCriterion("descr not in", values, "descr");
            return (Criteria) this;
        }

        public Criteria andDescrBetween(String value1, String value2) {
            addCriterion("descr between", value1, value2, "descr");
            return (Criteria) this;
        }

        public Criteria andDescrNotBetween(String value1, String value2) {
            addCriterion("descr not between", value1, value2, "descr");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdIsNull() {
            addCriterion("process_instance_id is null");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdIsNotNull() {
            addCriterion("process_instance_id is not null");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdEqualTo(String value) {
            addCriterion("process_instance_id =", value, "processInstanceId");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdNotEqualTo(String value) {
            addCriterion("process_instance_id <>", value, "processInstanceId");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdGreaterThan(String value) {
            addCriterion("process_instance_id >", value, "processInstanceId");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdGreaterThanOrEqualTo(String value) {
            addCriterion("process_instance_id >=", value, "processInstanceId");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdLessThan(String value) {
            addCriterion("process_instance_id <", value, "processInstanceId");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdLessThanOrEqualTo(String value) {
            addCriterion("process_instance_id <=", value, "processInstanceId");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdLike(String value) {
            addCriterion("process_instance_id like", value, "processInstanceId");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdNotLike(String value) {
            addCriterion("process_instance_id not like", value, "processInstanceId");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdIn(List<String> values) {
            addCriterion("process_instance_id in", values, "processInstanceId");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdNotIn(List<String> values) {
            addCriterion("process_instance_id not in", values, "processInstanceId");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdBetween(String value1, String value2) {
            addCriterion("process_instance_id between", value1, value2, "processInstanceId");
            return (Criteria) this;
        }

        public Criteria andProcessInstanceIdNotBetween(String value1, String value2) {
            addCriterion("process_instance_id not between", value1, value2, "processInstanceId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * @author admin
     * @date   2020-03-31
     */
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