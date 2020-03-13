/*
 * WorkflowBpmnModelExample.java
 * Copyright(c) 2017-2018 厦门网中网软件有限公司
 * All right reserved.
 * 2020-03-13 Created
 */
package cn.netinnet.workflow.activiti.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WorkflowBpmnModelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WorkflowBpmnModelExample() {
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
     * @date   2020-03-13
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

        public Criteria andModelIdIsNull() {
            addCriterion("model_id is null");
            return (Criteria) this;
        }

        public Criteria andModelIdIsNotNull() {
            addCriterion("model_id is not null");
            return (Criteria) this;
        }

        public Criteria andModelIdEqualTo(Long value) {
            addCriterion("model_id =", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotEqualTo(Long value) {
            addCriterion("model_id <>", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdGreaterThan(Long value) {
            addCriterion("model_id >", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdGreaterThanOrEqualTo(Long value) {
            addCriterion("model_id >=", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdLessThan(Long value) {
            addCriterion("model_id <", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdLessThanOrEqualTo(Long value) {
            addCriterion("model_id <=", value, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdIn(List<Long> values) {
            addCriterion("model_id in", values, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotIn(List<Long> values) {
            addCriterion("model_id not in", values, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdBetween(Long value1, Long value2) {
            addCriterion("model_id between", value1, value2, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelIdNotBetween(Long value1, Long value2) {
            addCriterion("model_id not between", value1, value2, "modelId");
            return (Criteria) this;
        }

        public Criteria andModelNameIsNull() {
            addCriterion("model_name is null");
            return (Criteria) this;
        }

        public Criteria andModelNameIsNotNull() {
            addCriterion("model_name is not null");
            return (Criteria) this;
        }

        public Criteria andModelNameEqualTo(String value) {
            addCriterion("model_name =", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameNotEqualTo(String value) {
            addCriterion("model_name <>", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameGreaterThan(String value) {
            addCriterion("model_name >", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameGreaterThanOrEqualTo(String value) {
            addCriterion("model_name >=", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameLessThan(String value) {
            addCriterion("model_name <", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameLessThanOrEqualTo(String value) {
            addCriterion("model_name <=", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameLike(String value) {
            addCriterion("model_name like", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameNotLike(String value) {
            addCriterion("model_name not like", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameIn(List<String> values) {
            addCriterion("model_name in", values, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameNotIn(List<String> values) {
            addCriterion("model_name not in", values, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameBetween(String value1, String value2) {
            addCriterion("model_name between", value1, value2, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameNotBetween(String value1, String value2) {
            addCriterion("model_name not between", value1, value2, "modelName");
            return (Criteria) this;
        }

        public Criteria andActivitiModelIdIsNull() {
            addCriterion("activiti_model_id is null");
            return (Criteria) this;
        }

        public Criteria andActivitiModelIdIsNotNull() {
            addCriterion("activiti_model_id is not null");
            return (Criteria) this;
        }

        public Criteria andActivitiModelIdEqualTo(String value) {
            addCriterion("activiti_model_id =", value, "activitiModelId");
            return (Criteria) this;
        }

        public Criteria andActivitiModelIdNotEqualTo(String value) {
            addCriterion("activiti_model_id <>", value, "activitiModelId");
            return (Criteria) this;
        }

        public Criteria andActivitiModelIdGreaterThan(String value) {
            addCriterion("activiti_model_id >", value, "activitiModelId");
            return (Criteria) this;
        }

        public Criteria andActivitiModelIdGreaterThanOrEqualTo(String value) {
            addCriterion("activiti_model_id >=", value, "activitiModelId");
            return (Criteria) this;
        }

        public Criteria andActivitiModelIdLessThan(String value) {
            addCriterion("activiti_model_id <", value, "activitiModelId");
            return (Criteria) this;
        }

        public Criteria andActivitiModelIdLessThanOrEqualTo(String value) {
            addCriterion("activiti_model_id <=", value, "activitiModelId");
            return (Criteria) this;
        }

        public Criteria andActivitiModelIdLike(String value) {
            addCriterion("activiti_model_id like", value, "activitiModelId");
            return (Criteria) this;
        }

        public Criteria andActivitiModelIdNotLike(String value) {
            addCriterion("activiti_model_id not like", value, "activitiModelId");
            return (Criteria) this;
        }

        public Criteria andActivitiModelIdIn(List<String> values) {
            addCriterion("activiti_model_id in", values, "activitiModelId");
            return (Criteria) this;
        }

        public Criteria andActivitiModelIdNotIn(List<String> values) {
            addCriterion("activiti_model_id not in", values, "activitiModelId");
            return (Criteria) this;
        }

        public Criteria andActivitiModelIdBetween(String value1, String value2) {
            addCriterion("activiti_model_id between", value1, value2, "activitiModelId");
            return (Criteria) this;
        }

        public Criteria andActivitiModelIdNotBetween(String value1, String value2) {
            addCriterion("activiti_model_id not between", value1, value2, "activitiModelId");
            return (Criteria) this;
        }

        public Criteria andBpmnImgaeIsNull() {
            addCriterion("bpmn_imgae is null");
            return (Criteria) this;
        }

        public Criteria andBpmnImgaeIsNotNull() {
            addCriterion("bpmn_imgae is not null");
            return (Criteria) this;
        }

        public Criteria andBpmnImgaeEqualTo(String value) {
            addCriterion("bpmn_imgae =", value, "bpmnImgae");
            return (Criteria) this;
        }

        public Criteria andBpmnImgaeNotEqualTo(String value) {
            addCriterion("bpmn_imgae <>", value, "bpmnImgae");
            return (Criteria) this;
        }

        public Criteria andBpmnImgaeGreaterThan(String value) {
            addCriterion("bpmn_imgae >", value, "bpmnImgae");
            return (Criteria) this;
        }

        public Criteria andBpmnImgaeGreaterThanOrEqualTo(String value) {
            addCriterion("bpmn_imgae >=", value, "bpmnImgae");
            return (Criteria) this;
        }

        public Criteria andBpmnImgaeLessThan(String value) {
            addCriterion("bpmn_imgae <", value, "bpmnImgae");
            return (Criteria) this;
        }

        public Criteria andBpmnImgaeLessThanOrEqualTo(String value) {
            addCriterion("bpmn_imgae <=", value, "bpmnImgae");
            return (Criteria) this;
        }

        public Criteria andBpmnImgaeLike(String value) {
            addCriterion("bpmn_imgae like", value, "bpmnImgae");
            return (Criteria) this;
        }

        public Criteria andBpmnImgaeNotLike(String value) {
            addCriterion("bpmn_imgae not like", value, "bpmnImgae");
            return (Criteria) this;
        }

        public Criteria andBpmnImgaeIn(List<String> values) {
            addCriterion("bpmn_imgae in", values, "bpmnImgae");
            return (Criteria) this;
        }

        public Criteria andBpmnImgaeNotIn(List<String> values) {
            addCriterion("bpmn_imgae not in", values, "bpmnImgae");
            return (Criteria) this;
        }

        public Criteria andBpmnImgaeBetween(String value1, String value2) {
            addCriterion("bpmn_imgae between", value1, value2, "bpmnImgae");
            return (Criteria) this;
        }

        public Criteria andBpmnImgaeNotBetween(String value1, String value2) {
            addCriterion("bpmn_imgae not between", value1, value2, "bpmnImgae");
            return (Criteria) this;
        }

        public Criteria andBpmnXmlIsNull() {
            addCriterion("bpmn_xml is null");
            return (Criteria) this;
        }

        public Criteria andBpmnXmlIsNotNull() {
            addCriterion("bpmn_xml is not null");
            return (Criteria) this;
        }

        public Criteria andBpmnXmlEqualTo(String value) {
            addCriterion("bpmn_xml =", value, "bpmnXml");
            return (Criteria) this;
        }

        public Criteria andBpmnXmlNotEqualTo(String value) {
            addCriterion("bpmn_xml <>", value, "bpmnXml");
            return (Criteria) this;
        }

        public Criteria andBpmnXmlGreaterThan(String value) {
            addCriterion("bpmn_xml >", value, "bpmnXml");
            return (Criteria) this;
        }

        public Criteria andBpmnXmlGreaterThanOrEqualTo(String value) {
            addCriterion("bpmn_xml >=", value, "bpmnXml");
            return (Criteria) this;
        }

        public Criteria andBpmnXmlLessThan(String value) {
            addCriterion("bpmn_xml <", value, "bpmnXml");
            return (Criteria) this;
        }

        public Criteria andBpmnXmlLessThanOrEqualTo(String value) {
            addCriterion("bpmn_xml <=", value, "bpmnXml");
            return (Criteria) this;
        }

        public Criteria andBpmnXmlLike(String value) {
            addCriterion("bpmn_xml like", value, "bpmnXml");
            return (Criteria) this;
        }

        public Criteria andBpmnXmlNotLike(String value) {
            addCriterion("bpmn_xml not like", value, "bpmnXml");
            return (Criteria) this;
        }

        public Criteria andBpmnXmlIn(List<String> values) {
            addCriterion("bpmn_xml in", values, "bpmnXml");
            return (Criteria) this;
        }

        public Criteria andBpmnXmlNotIn(List<String> values) {
            addCriterion("bpmn_xml not in", values, "bpmnXml");
            return (Criteria) this;
        }

        public Criteria andBpmnXmlBetween(String value1, String value2) {
            addCriterion("bpmn_xml between", value1, value2, "bpmnXml");
            return (Criteria) this;
        }

        public Criteria andBpmnXmlNotBetween(String value1, String value2) {
            addCriterion("bpmn_xml not between", value1, value2, "bpmnXml");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIsNull() {
            addCriterion("create_user_id is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIsNotNull() {
            addCriterion("create_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdEqualTo(Long value) {
            addCriterion("create_user_id =", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotEqualTo(Long value) {
            addCriterion("create_user_id <>", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThan(Long value) {
            addCriterion("create_user_id >", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("create_user_id >=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThan(Long value) {
            addCriterion("create_user_id <", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThanOrEqualTo(Long value) {
            addCriterion("create_user_id <=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIn(List<Long> values) {
            addCriterion("create_user_id in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotIn(List<Long> values) {
            addCriterion("create_user_id not in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdBetween(Long value1, Long value2) {
            addCriterion("create_user_id between", value1, value2, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotBetween(Long value1, Long value2) {
            addCriterion("create_user_id not between", value1, value2, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
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
     * @date   2020-03-13
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