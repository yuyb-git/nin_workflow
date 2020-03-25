/*
 * FormMaterialExample.java
 * Copyright(c) 2017-2018 厦门网中网软件有限公司
 * All right reserved.
 * 2020-03-25 Created
 */
package cn.netinnet.workflow.activiti.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class FormMaterialExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FormMaterialExample() {
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
     * @date   2020-03-25
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andFormTitleIsNull() {
            addCriterion("form_title is null");
            return (Criteria) this;
        }

        public Criteria andFormTitleIsNotNull() {
            addCriterion("form_title is not null");
            return (Criteria) this;
        }

        public Criteria andFormTitleEqualTo(String value) {
            addCriterion("form_title =", value, "formTitle");
            return (Criteria) this;
        }

        public Criteria andFormTitleNotEqualTo(String value) {
            addCriterion("form_title <>", value, "formTitle");
            return (Criteria) this;
        }

        public Criteria andFormTitleGreaterThan(String value) {
            addCriterion("form_title >", value, "formTitle");
            return (Criteria) this;
        }

        public Criteria andFormTitleGreaterThanOrEqualTo(String value) {
            addCriterion("form_title >=", value, "formTitle");
            return (Criteria) this;
        }

        public Criteria andFormTitleLessThan(String value) {
            addCriterion("form_title <", value, "formTitle");
            return (Criteria) this;
        }

        public Criteria andFormTitleLessThanOrEqualTo(String value) {
            addCriterion("form_title <=", value, "formTitle");
            return (Criteria) this;
        }

        public Criteria andFormTitleLike(String value) {
            addCriterion("form_title like", value, "formTitle");
            return (Criteria) this;
        }

        public Criteria andFormTitleNotLike(String value) {
            addCriterion("form_title not like", value, "formTitle");
            return (Criteria) this;
        }

        public Criteria andFormTitleIn(List<String> values) {
            addCriterion("form_title in", values, "formTitle");
            return (Criteria) this;
        }

        public Criteria andFormTitleNotIn(List<String> values) {
            addCriterion("form_title not in", values, "formTitle");
            return (Criteria) this;
        }

        public Criteria andFormTitleBetween(String value1, String value2) {
            addCriterion("form_title between", value1, value2, "formTitle");
            return (Criteria) this;
        }

        public Criteria andFormTitleNotBetween(String value1, String value2) {
            addCriterion("form_title not between", value1, value2, "formTitle");
            return (Criteria) this;
        }

        public Criteria andAccountCompanyIsNull() {
            addCriterion("account_company is null");
            return (Criteria) this;
        }

        public Criteria andAccountCompanyIsNotNull() {
            addCriterion("account_company is not null");
            return (Criteria) this;
        }

        public Criteria andAccountCompanyEqualTo(String value) {
            addCriterion("account_company =", value, "accountCompany");
            return (Criteria) this;
        }

        public Criteria andAccountCompanyNotEqualTo(String value) {
            addCriterion("account_company <>", value, "accountCompany");
            return (Criteria) this;
        }

        public Criteria andAccountCompanyGreaterThan(String value) {
            addCriterion("account_company >", value, "accountCompany");
            return (Criteria) this;
        }

        public Criteria andAccountCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("account_company >=", value, "accountCompany");
            return (Criteria) this;
        }

        public Criteria andAccountCompanyLessThan(String value) {
            addCriterion("account_company <", value, "accountCompany");
            return (Criteria) this;
        }

        public Criteria andAccountCompanyLessThanOrEqualTo(String value) {
            addCriterion("account_company <=", value, "accountCompany");
            return (Criteria) this;
        }

        public Criteria andAccountCompanyLike(String value) {
            addCriterion("account_company like", value, "accountCompany");
            return (Criteria) this;
        }

        public Criteria andAccountCompanyNotLike(String value) {
            addCriterion("account_company not like", value, "accountCompany");
            return (Criteria) this;
        }

        public Criteria andAccountCompanyIn(List<String> values) {
            addCriterion("account_company in", values, "accountCompany");
            return (Criteria) this;
        }

        public Criteria andAccountCompanyNotIn(List<String> values) {
            addCriterion("account_company not in", values, "accountCompany");
            return (Criteria) this;
        }

        public Criteria andAccountCompanyBetween(String value1, String value2) {
            addCriterion("account_company between", value1, value2, "accountCompany");
            return (Criteria) this;
        }

        public Criteria andAccountCompanyNotBetween(String value1, String value2) {
            addCriterion("account_company not between", value1, value2, "accountCompany");
            return (Criteria) this;
        }

        public Criteria andApplicationIsNull() {
            addCriterion("application is null");
            return (Criteria) this;
        }

        public Criteria andApplicationIsNotNull() {
            addCriterion("application is not null");
            return (Criteria) this;
        }

        public Criteria andApplicationEqualTo(String value) {
            addCriterion("application =", value, "application");
            return (Criteria) this;
        }

        public Criteria andApplicationNotEqualTo(String value) {
            addCriterion("application <>", value, "application");
            return (Criteria) this;
        }

        public Criteria andApplicationGreaterThan(String value) {
            addCriterion("application >", value, "application");
            return (Criteria) this;
        }

        public Criteria andApplicationGreaterThanOrEqualTo(String value) {
            addCriterion("application >=", value, "application");
            return (Criteria) this;
        }

        public Criteria andApplicationLessThan(String value) {
            addCriterion("application <", value, "application");
            return (Criteria) this;
        }

        public Criteria andApplicationLessThanOrEqualTo(String value) {
            addCriterion("application <=", value, "application");
            return (Criteria) this;
        }

        public Criteria andApplicationLike(String value) {
            addCriterion("application like", value, "application");
            return (Criteria) this;
        }

        public Criteria andApplicationNotLike(String value) {
            addCriterion("application not like", value, "application");
            return (Criteria) this;
        }

        public Criteria andApplicationIn(List<String> values) {
            addCriterion("application in", values, "application");
            return (Criteria) this;
        }

        public Criteria andApplicationNotIn(List<String> values) {
            addCriterion("application not in", values, "application");
            return (Criteria) this;
        }

        public Criteria andApplicationBetween(String value1, String value2) {
            addCriterion("application between", value1, value2, "application");
            return (Criteria) this;
        }

        public Criteria andApplicationNotBetween(String value1, String value2) {
            addCriterion("application not between", value1, value2, "application");
            return (Criteria) this;
        }

        public Criteria andFillerIsNull() {
            addCriterion("filler is null");
            return (Criteria) this;
        }

        public Criteria andFillerIsNotNull() {
            addCriterion("filler is not null");
            return (Criteria) this;
        }

        public Criteria andFillerEqualTo(String value) {
            addCriterion("filler =", value, "filler");
            return (Criteria) this;
        }

        public Criteria andFillerNotEqualTo(String value) {
            addCriterion("filler <>", value, "filler");
            return (Criteria) this;
        }

        public Criteria andFillerGreaterThan(String value) {
            addCriterion("filler >", value, "filler");
            return (Criteria) this;
        }

        public Criteria andFillerGreaterThanOrEqualTo(String value) {
            addCriterion("filler >=", value, "filler");
            return (Criteria) this;
        }

        public Criteria andFillerLessThan(String value) {
            addCriterion("filler <", value, "filler");
            return (Criteria) this;
        }

        public Criteria andFillerLessThanOrEqualTo(String value) {
            addCriterion("filler <=", value, "filler");
            return (Criteria) this;
        }

        public Criteria andFillerLike(String value) {
            addCriterion("filler like", value, "filler");
            return (Criteria) this;
        }

        public Criteria andFillerNotLike(String value) {
            addCriterion("filler not like", value, "filler");
            return (Criteria) this;
        }

        public Criteria andFillerIn(List<String> values) {
            addCriterion("filler in", values, "filler");
            return (Criteria) this;
        }

        public Criteria andFillerNotIn(List<String> values) {
            addCriterion("filler not in", values, "filler");
            return (Criteria) this;
        }

        public Criteria andFillerBetween(String value1, String value2) {
            addCriterion("filler between", value1, value2, "filler");
            return (Criteria) this;
        }

        public Criteria andFillerNotBetween(String value1, String value2) {
            addCriterion("filler not between", value1, value2, "filler");
            return (Criteria) this;
        }

        public Criteria andFillDateIsNull() {
            addCriterion("fill_date is null");
            return (Criteria) this;
        }

        public Criteria andFillDateIsNotNull() {
            addCriterion("fill_date is not null");
            return (Criteria) this;
        }

        public Criteria andFillDateEqualTo(Date value) {
            addCriterionForJDBCDate("fill_date =", value, "fillDate");
            return (Criteria) this;
        }

        public Criteria andFillDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("fill_date <>", value, "fillDate");
            return (Criteria) this;
        }

        public Criteria andFillDateGreaterThan(Date value) {
            addCriterionForJDBCDate("fill_date >", value, "fillDate");
            return (Criteria) this;
        }

        public Criteria andFillDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("fill_date >=", value, "fillDate");
            return (Criteria) this;
        }

        public Criteria andFillDateLessThan(Date value) {
            addCriterionForJDBCDate("fill_date <", value, "fillDate");
            return (Criteria) this;
        }

        public Criteria andFillDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("fill_date <=", value, "fillDate");
            return (Criteria) this;
        }

        public Criteria andFillDateIn(List<Date> values) {
            addCriterionForJDBCDate("fill_date in", values, "fillDate");
            return (Criteria) this;
        }

        public Criteria andFillDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("fill_date not in", values, "fillDate");
            return (Criteria) this;
        }

        public Criteria andFillDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("fill_date between", value1, value2, "fillDate");
            return (Criteria) this;
        }

        public Criteria andFillDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("fill_date not between", value1, value2, "fillDate");
            return (Criteria) this;
        }

        public Criteria andApplierIdIsNull() {
            addCriterion("applier_id is null");
            return (Criteria) this;
        }

        public Criteria andApplierIdIsNotNull() {
            addCriterion("applier_id is not null");
            return (Criteria) this;
        }

        public Criteria andApplierIdEqualTo(Long value) {
            addCriterion("applier_id =", value, "applierId");
            return (Criteria) this;
        }

        public Criteria andApplierIdNotEqualTo(Long value) {
            addCriterion("applier_id <>", value, "applierId");
            return (Criteria) this;
        }

        public Criteria andApplierIdGreaterThan(Long value) {
            addCriterion("applier_id >", value, "applierId");
            return (Criteria) this;
        }

        public Criteria andApplierIdGreaterThanOrEqualTo(Long value) {
            addCriterion("applier_id >=", value, "applierId");
            return (Criteria) this;
        }

        public Criteria andApplierIdLessThan(Long value) {
            addCriterion("applier_id <", value, "applierId");
            return (Criteria) this;
        }

        public Criteria andApplierIdLessThanOrEqualTo(Long value) {
            addCriterion("applier_id <=", value, "applierId");
            return (Criteria) this;
        }

        public Criteria andApplierIdIn(List<Long> values) {
            addCriterion("applier_id in", values, "applierId");
            return (Criteria) this;
        }

        public Criteria andApplierIdNotIn(List<Long> values) {
            addCriterion("applier_id not in", values, "applierId");
            return (Criteria) this;
        }

        public Criteria andApplierIdBetween(Long value1, Long value2) {
            addCriterion("applier_id between", value1, value2, "applierId");
            return (Criteria) this;
        }

        public Criteria andApplierIdNotBetween(Long value1, Long value2) {
            addCriterion("applier_id not between", value1, value2, "applierId");
            return (Criteria) this;
        }

        public Criteria andApplierNameIsNull() {
            addCriterion("applier_name is null");
            return (Criteria) this;
        }

        public Criteria andApplierNameIsNotNull() {
            addCriterion("applier_name is not null");
            return (Criteria) this;
        }

        public Criteria andApplierNameEqualTo(String value) {
            addCriterion("applier_name =", value, "applierName");
            return (Criteria) this;
        }

        public Criteria andApplierNameNotEqualTo(String value) {
            addCriterion("applier_name <>", value, "applierName");
            return (Criteria) this;
        }

        public Criteria andApplierNameGreaterThan(String value) {
            addCriterion("applier_name >", value, "applierName");
            return (Criteria) this;
        }

        public Criteria andApplierNameGreaterThanOrEqualTo(String value) {
            addCriterion("applier_name >=", value, "applierName");
            return (Criteria) this;
        }

        public Criteria andApplierNameLessThan(String value) {
            addCriterion("applier_name <", value, "applierName");
            return (Criteria) this;
        }

        public Criteria andApplierNameLessThanOrEqualTo(String value) {
            addCriterion("applier_name <=", value, "applierName");
            return (Criteria) this;
        }

        public Criteria andApplierNameLike(String value) {
            addCriterion("applier_name like", value, "applierName");
            return (Criteria) this;
        }

        public Criteria andApplierNameNotLike(String value) {
            addCriterion("applier_name not like", value, "applierName");
            return (Criteria) this;
        }

        public Criteria andApplierNameIn(List<String> values) {
            addCriterion("applier_name in", values, "applierName");
            return (Criteria) this;
        }

        public Criteria andApplierNameNotIn(List<String> values) {
            addCriterion("applier_name not in", values, "applierName");
            return (Criteria) this;
        }

        public Criteria andApplierNameBetween(String value1, String value2) {
            addCriterion("applier_name between", value1, value2, "applierName");
            return (Criteria) this;
        }

        public Criteria andApplierNameNotBetween(String value1, String value2) {
            addCriterion("applier_name not between", value1, value2, "applierName");
            return (Criteria) this;
        }

        public Criteria andApplierTelIsNull() {
            addCriterion("applier_tel is null");
            return (Criteria) this;
        }

        public Criteria andApplierTelIsNotNull() {
            addCriterion("applier_tel is not null");
            return (Criteria) this;
        }

        public Criteria andApplierTelEqualTo(String value) {
            addCriterion("applier_tel =", value, "applierTel");
            return (Criteria) this;
        }

        public Criteria andApplierTelNotEqualTo(String value) {
            addCriterion("applier_tel <>", value, "applierTel");
            return (Criteria) this;
        }

        public Criteria andApplierTelGreaterThan(String value) {
            addCriterion("applier_tel >", value, "applierTel");
            return (Criteria) this;
        }

        public Criteria andApplierTelGreaterThanOrEqualTo(String value) {
            addCriterion("applier_tel >=", value, "applierTel");
            return (Criteria) this;
        }

        public Criteria andApplierTelLessThan(String value) {
            addCriterion("applier_tel <", value, "applierTel");
            return (Criteria) this;
        }

        public Criteria andApplierTelLessThanOrEqualTo(String value) {
            addCriterion("applier_tel <=", value, "applierTel");
            return (Criteria) this;
        }

        public Criteria andApplierTelLike(String value) {
            addCriterion("applier_tel like", value, "applierTel");
            return (Criteria) this;
        }

        public Criteria andApplierTelNotLike(String value) {
            addCriterion("applier_tel not like", value, "applierTel");
            return (Criteria) this;
        }

        public Criteria andApplierTelIn(List<String> values) {
            addCriterion("applier_tel in", values, "applierTel");
            return (Criteria) this;
        }

        public Criteria andApplierTelNotIn(List<String> values) {
            addCriterion("applier_tel not in", values, "applierTel");
            return (Criteria) this;
        }

        public Criteria andApplierTelBetween(String value1, String value2) {
            addCriterion("applier_tel between", value1, value2, "applierTel");
            return (Criteria) this;
        }

        public Criteria andApplierTelNotBetween(String value1, String value2) {
            addCriterion("applier_tel not between", value1, value2, "applierTel");
            return (Criteria) this;
        }

        public Criteria andApplierDeptIdIsNull() {
            addCriterion("applier_dept_id is null");
            return (Criteria) this;
        }

        public Criteria andApplierDeptIdIsNotNull() {
            addCriterion("applier_dept_id is not null");
            return (Criteria) this;
        }

        public Criteria andApplierDeptIdEqualTo(Long value) {
            addCriterion("applier_dept_id =", value, "applierDeptId");
            return (Criteria) this;
        }

        public Criteria andApplierDeptIdNotEqualTo(Long value) {
            addCriterion("applier_dept_id <>", value, "applierDeptId");
            return (Criteria) this;
        }

        public Criteria andApplierDeptIdGreaterThan(Long value) {
            addCriterion("applier_dept_id >", value, "applierDeptId");
            return (Criteria) this;
        }

        public Criteria andApplierDeptIdGreaterThanOrEqualTo(Long value) {
            addCriterion("applier_dept_id >=", value, "applierDeptId");
            return (Criteria) this;
        }

        public Criteria andApplierDeptIdLessThan(Long value) {
            addCriterion("applier_dept_id <", value, "applierDeptId");
            return (Criteria) this;
        }

        public Criteria andApplierDeptIdLessThanOrEqualTo(Long value) {
            addCriterion("applier_dept_id <=", value, "applierDeptId");
            return (Criteria) this;
        }

        public Criteria andApplierDeptIdIn(List<Long> values) {
            addCriterion("applier_dept_id in", values, "applierDeptId");
            return (Criteria) this;
        }

        public Criteria andApplierDeptIdNotIn(List<Long> values) {
            addCriterion("applier_dept_id not in", values, "applierDeptId");
            return (Criteria) this;
        }

        public Criteria andApplierDeptIdBetween(Long value1, Long value2) {
            addCriterion("applier_dept_id between", value1, value2, "applierDeptId");
            return (Criteria) this;
        }

        public Criteria andApplierDeptIdNotBetween(Long value1, Long value2) {
            addCriterion("applier_dept_id not between", value1, value2, "applierDeptId");
            return (Criteria) this;
        }

        public Criteria andApplierDeptIsNull() {
            addCriterion("applier_dept is null");
            return (Criteria) this;
        }

        public Criteria andApplierDeptIsNotNull() {
            addCriterion("applier_dept is not null");
            return (Criteria) this;
        }

        public Criteria andApplierDeptEqualTo(String value) {
            addCriterion("applier_dept =", value, "applierDept");
            return (Criteria) this;
        }

        public Criteria andApplierDeptNotEqualTo(String value) {
            addCriterion("applier_dept <>", value, "applierDept");
            return (Criteria) this;
        }

        public Criteria andApplierDeptGreaterThan(String value) {
            addCriterion("applier_dept >", value, "applierDept");
            return (Criteria) this;
        }

        public Criteria andApplierDeptGreaterThanOrEqualTo(String value) {
            addCriterion("applier_dept >=", value, "applierDept");
            return (Criteria) this;
        }

        public Criteria andApplierDeptLessThan(String value) {
            addCriterion("applier_dept <", value, "applierDept");
            return (Criteria) this;
        }

        public Criteria andApplierDeptLessThanOrEqualTo(String value) {
            addCriterion("applier_dept <=", value, "applierDept");
            return (Criteria) this;
        }

        public Criteria andApplierDeptLike(String value) {
            addCriterion("applier_dept like", value, "applierDept");
            return (Criteria) this;
        }

        public Criteria andApplierDeptNotLike(String value) {
            addCriterion("applier_dept not like", value, "applierDept");
            return (Criteria) this;
        }

        public Criteria andApplierDeptIn(List<String> values) {
            addCriterion("applier_dept in", values, "applierDept");
            return (Criteria) this;
        }

        public Criteria andApplierDeptNotIn(List<String> values) {
            addCriterion("applier_dept not in", values, "applierDept");
            return (Criteria) this;
        }

        public Criteria andApplierDeptBetween(String value1, String value2) {
            addCriterion("applier_dept between", value1, value2, "applierDept");
            return (Criteria) this;
        }

        public Criteria andApplierDeptNotBetween(String value1, String value2) {
            addCriterion("applier_dept not between", value1, value2, "applierDept");
            return (Criteria) this;
        }

        public Criteria andArrivalDateIsNull() {
            addCriterion("arrival_date is null");
            return (Criteria) this;
        }

        public Criteria andArrivalDateIsNotNull() {
            addCriterion("arrival_date is not null");
            return (Criteria) this;
        }

        public Criteria andArrivalDateEqualTo(Date value) {
            addCriterionForJDBCDate("arrival_date =", value, "arrivalDate");
            return (Criteria) this;
        }

        public Criteria andArrivalDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("arrival_date <>", value, "arrivalDate");
            return (Criteria) this;
        }

        public Criteria andArrivalDateGreaterThan(Date value) {
            addCriterionForJDBCDate("arrival_date >", value, "arrivalDate");
            return (Criteria) this;
        }

        public Criteria andArrivalDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("arrival_date >=", value, "arrivalDate");
            return (Criteria) this;
        }

        public Criteria andArrivalDateLessThan(Date value) {
            addCriterionForJDBCDate("arrival_date <", value, "arrivalDate");
            return (Criteria) this;
        }

        public Criteria andArrivalDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("arrival_date <=", value, "arrivalDate");
            return (Criteria) this;
        }

        public Criteria andArrivalDateIn(List<Date> values) {
            addCriterionForJDBCDate("arrival_date in", values, "arrivalDate");
            return (Criteria) this;
        }

        public Criteria andArrivalDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("arrival_date not in", values, "arrivalDate");
            return (Criteria) this;
        }

        public Criteria andArrivalDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("arrival_date between", value1, value2, "arrivalDate");
            return (Criteria) this;
        }

        public Criteria andArrivalDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("arrival_date not between", value1, value2, "arrivalDate");
            return (Criteria) this;
        }

        public Criteria andApproverIdIsNull() {
            addCriterion("approver_id is null");
            return (Criteria) this;
        }

        public Criteria andApproverIdIsNotNull() {
            addCriterion("approver_id is not null");
            return (Criteria) this;
        }

        public Criteria andApproverIdEqualTo(Long value) {
            addCriterion("approver_id =", value, "approverId");
            return (Criteria) this;
        }

        public Criteria andApproverIdNotEqualTo(Long value) {
            addCriterion("approver_id <>", value, "approverId");
            return (Criteria) this;
        }

        public Criteria andApproverIdGreaterThan(Long value) {
            addCriterion("approver_id >", value, "approverId");
            return (Criteria) this;
        }

        public Criteria andApproverIdGreaterThanOrEqualTo(Long value) {
            addCriterion("approver_id >=", value, "approverId");
            return (Criteria) this;
        }

        public Criteria andApproverIdLessThan(Long value) {
            addCriterion("approver_id <", value, "approverId");
            return (Criteria) this;
        }

        public Criteria andApproverIdLessThanOrEqualTo(Long value) {
            addCriterion("approver_id <=", value, "approverId");
            return (Criteria) this;
        }

        public Criteria andApproverIdIn(List<Long> values) {
            addCriterion("approver_id in", values, "approverId");
            return (Criteria) this;
        }

        public Criteria andApproverIdNotIn(List<Long> values) {
            addCriterion("approver_id not in", values, "approverId");
            return (Criteria) this;
        }

        public Criteria andApproverIdBetween(Long value1, Long value2) {
            addCriterion("approver_id between", value1, value2, "approverId");
            return (Criteria) this;
        }

        public Criteria andApproverIdNotBetween(Long value1, Long value2) {
            addCriterion("approver_id not between", value1, value2, "approverId");
            return (Criteria) this;
        }

        public Criteria andApproverNameIsNull() {
            addCriterion("approver_name is null");
            return (Criteria) this;
        }

        public Criteria andApproverNameIsNotNull() {
            addCriterion("approver_name is not null");
            return (Criteria) this;
        }

        public Criteria andApproverNameEqualTo(String value) {
            addCriterion("approver_name =", value, "approverName");
            return (Criteria) this;
        }

        public Criteria andApproverNameNotEqualTo(String value) {
            addCriterion("approver_name <>", value, "approverName");
            return (Criteria) this;
        }

        public Criteria andApproverNameGreaterThan(String value) {
            addCriterion("approver_name >", value, "approverName");
            return (Criteria) this;
        }

        public Criteria andApproverNameGreaterThanOrEqualTo(String value) {
            addCriterion("approver_name >=", value, "approverName");
            return (Criteria) this;
        }

        public Criteria andApproverNameLessThan(String value) {
            addCriterion("approver_name <", value, "approverName");
            return (Criteria) this;
        }

        public Criteria andApproverNameLessThanOrEqualTo(String value) {
            addCriterion("approver_name <=", value, "approverName");
            return (Criteria) this;
        }

        public Criteria andApproverNameLike(String value) {
            addCriterion("approver_name like", value, "approverName");
            return (Criteria) this;
        }

        public Criteria andApproverNameNotLike(String value) {
            addCriterion("approver_name not like", value, "approverName");
            return (Criteria) this;
        }

        public Criteria andApproverNameIn(List<String> values) {
            addCriterion("approver_name in", values, "approverName");
            return (Criteria) this;
        }

        public Criteria andApproverNameNotIn(List<String> values) {
            addCriterion("approver_name not in", values, "approverName");
            return (Criteria) this;
        }

        public Criteria andApproverNameBetween(String value1, String value2) {
            addCriterion("approver_name between", value1, value2, "approverName");
            return (Criteria) this;
        }

        public Criteria andApproverNameNotBetween(String value1, String value2) {
            addCriterion("approver_name not between", value1, value2, "approverName");
            return (Criteria) this;
        }

        public Criteria andApproverDeptIdIsNull() {
            addCriterion("approver_dept_id is null");
            return (Criteria) this;
        }

        public Criteria andApproverDeptIdIsNotNull() {
            addCriterion("approver_dept_id is not null");
            return (Criteria) this;
        }

        public Criteria andApproverDeptIdEqualTo(Long value) {
            addCriterion("approver_dept_id =", value, "approverDeptId");
            return (Criteria) this;
        }

        public Criteria andApproverDeptIdNotEqualTo(Long value) {
            addCriterion("approver_dept_id <>", value, "approverDeptId");
            return (Criteria) this;
        }

        public Criteria andApproverDeptIdGreaterThan(Long value) {
            addCriterion("approver_dept_id >", value, "approverDeptId");
            return (Criteria) this;
        }

        public Criteria andApproverDeptIdGreaterThanOrEqualTo(Long value) {
            addCriterion("approver_dept_id >=", value, "approverDeptId");
            return (Criteria) this;
        }

        public Criteria andApproverDeptIdLessThan(Long value) {
            addCriterion("approver_dept_id <", value, "approverDeptId");
            return (Criteria) this;
        }

        public Criteria andApproverDeptIdLessThanOrEqualTo(Long value) {
            addCriterion("approver_dept_id <=", value, "approverDeptId");
            return (Criteria) this;
        }

        public Criteria andApproverDeptIdIn(List<Long> values) {
            addCriterion("approver_dept_id in", values, "approverDeptId");
            return (Criteria) this;
        }

        public Criteria andApproverDeptIdNotIn(List<Long> values) {
            addCriterion("approver_dept_id not in", values, "approverDeptId");
            return (Criteria) this;
        }

        public Criteria andApproverDeptIdBetween(Long value1, Long value2) {
            addCriterion("approver_dept_id between", value1, value2, "approverDeptId");
            return (Criteria) this;
        }

        public Criteria andApproverDeptIdNotBetween(Long value1, Long value2) {
            addCriterion("approver_dept_id not between", value1, value2, "approverDeptId");
            return (Criteria) this;
        }

        public Criteria andApproverDeptIsNull() {
            addCriterion("approver_dept is null");
            return (Criteria) this;
        }

        public Criteria andApproverDeptIsNotNull() {
            addCriterion("approver_dept is not null");
            return (Criteria) this;
        }

        public Criteria andApproverDeptEqualTo(String value) {
            addCriterion("approver_dept =", value, "approverDept");
            return (Criteria) this;
        }

        public Criteria andApproverDeptNotEqualTo(String value) {
            addCriterion("approver_dept <>", value, "approverDept");
            return (Criteria) this;
        }

        public Criteria andApproverDeptGreaterThan(String value) {
            addCriterion("approver_dept >", value, "approverDept");
            return (Criteria) this;
        }

        public Criteria andApproverDeptGreaterThanOrEqualTo(String value) {
            addCriterion("approver_dept >=", value, "approverDept");
            return (Criteria) this;
        }

        public Criteria andApproverDeptLessThan(String value) {
            addCriterion("approver_dept <", value, "approverDept");
            return (Criteria) this;
        }

        public Criteria andApproverDeptLessThanOrEqualTo(String value) {
            addCriterion("approver_dept <=", value, "approverDept");
            return (Criteria) this;
        }

        public Criteria andApproverDeptLike(String value) {
            addCriterion("approver_dept like", value, "approverDept");
            return (Criteria) this;
        }

        public Criteria andApproverDeptNotLike(String value) {
            addCriterion("approver_dept not like", value, "approverDept");
            return (Criteria) this;
        }

        public Criteria andApproverDeptIn(List<String> values) {
            addCriterion("approver_dept in", values, "approverDept");
            return (Criteria) this;
        }

        public Criteria andApproverDeptNotIn(List<String> values) {
            addCriterion("approver_dept not in", values, "approverDept");
            return (Criteria) this;
        }

        public Criteria andApproverDeptBetween(String value1, String value2) {
            addCriterion("approver_dept between", value1, value2, "approverDept");
            return (Criteria) this;
        }

        public Criteria andApproverDeptNotBetween(String value1, String value2) {
            addCriterion("approver_dept not between", value1, value2, "approverDept");
            return (Criteria) this;
        }

        public Criteria andApproveOpinionIsNull() {
            addCriterion("approve_opinion is null");
            return (Criteria) this;
        }

        public Criteria andApproveOpinionIsNotNull() {
            addCriterion("approve_opinion is not null");
            return (Criteria) this;
        }

        public Criteria andApproveOpinionEqualTo(String value) {
            addCriterion("approve_opinion =", value, "approveOpinion");
            return (Criteria) this;
        }

        public Criteria andApproveOpinionNotEqualTo(String value) {
            addCriterion("approve_opinion <>", value, "approveOpinion");
            return (Criteria) this;
        }

        public Criteria andApproveOpinionGreaterThan(String value) {
            addCriterion("approve_opinion >", value, "approveOpinion");
            return (Criteria) this;
        }

        public Criteria andApproveOpinionGreaterThanOrEqualTo(String value) {
            addCriterion("approve_opinion >=", value, "approveOpinion");
            return (Criteria) this;
        }

        public Criteria andApproveOpinionLessThan(String value) {
            addCriterion("approve_opinion <", value, "approveOpinion");
            return (Criteria) this;
        }

        public Criteria andApproveOpinionLessThanOrEqualTo(String value) {
            addCriterion("approve_opinion <=", value, "approveOpinion");
            return (Criteria) this;
        }

        public Criteria andApproveOpinionLike(String value) {
            addCriterion("approve_opinion like", value, "approveOpinion");
            return (Criteria) this;
        }

        public Criteria andApproveOpinionNotLike(String value) {
            addCriterion("approve_opinion not like", value, "approveOpinion");
            return (Criteria) this;
        }

        public Criteria andApproveOpinionIn(List<String> values) {
            addCriterion("approve_opinion in", values, "approveOpinion");
            return (Criteria) this;
        }

        public Criteria andApproveOpinionNotIn(List<String> values) {
            addCriterion("approve_opinion not in", values, "approveOpinion");
            return (Criteria) this;
        }

        public Criteria andApproveOpinionBetween(String value1, String value2) {
            addCriterion("approve_opinion between", value1, value2, "approveOpinion");
            return (Criteria) this;
        }

        public Criteria andApproveOpinionNotBetween(String value1, String value2) {
            addCriterion("approve_opinion not between", value1, value2, "approveOpinion");
            return (Criteria) this;
        }

        public Criteria andApproveDateIsNull() {
            addCriterion("approve_date is null");
            return (Criteria) this;
        }

        public Criteria andApproveDateIsNotNull() {
            addCriterion("approve_date is not null");
            return (Criteria) this;
        }

        public Criteria andApproveDateEqualTo(Date value) {
            addCriterionForJDBCDate("approve_date =", value, "approveDate");
            return (Criteria) this;
        }

        public Criteria andApproveDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("approve_date <>", value, "approveDate");
            return (Criteria) this;
        }

        public Criteria andApproveDateGreaterThan(Date value) {
            addCriterionForJDBCDate("approve_date >", value, "approveDate");
            return (Criteria) this;
        }

        public Criteria andApproveDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("approve_date >=", value, "approveDate");
            return (Criteria) this;
        }

        public Criteria andApproveDateLessThan(Date value) {
            addCriterionForJDBCDate("approve_date <", value, "approveDate");
            return (Criteria) this;
        }

        public Criteria andApproveDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("approve_date <=", value, "approveDate");
            return (Criteria) this;
        }

        public Criteria andApproveDateIn(List<Date> values) {
            addCriterionForJDBCDate("approve_date in", values, "approveDate");
            return (Criteria) this;
        }

        public Criteria andApproveDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("approve_date not in", values, "approveDate");
            return (Criteria) this;
        }

        public Criteria andApproveDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("approve_date between", value1, value2, "approveDate");
            return (Criteria) this;
        }

        public Criteria andApproveDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("approve_date not between", value1, value2, "approveDate");
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
     * @date   2020-03-25
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