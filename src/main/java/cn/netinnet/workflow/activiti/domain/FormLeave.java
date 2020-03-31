/*
 * FormLeave.java
 * Copyright(c) 2017-2018 厦门网中网软件有限公司
 * All right reserved.
 * 2020-03-31 Created
 */
package cn.netinnet.workflow.activiti.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author admin
 * @date   2020-03-31
 **/
public class FormLeave implements Serializable {
    /**
     * id
     */
    private Long formId;

    /**
     * 单号
     */
    private Long formNo;

    /**
     * 请假人用户id
     */
    private Long leaverId;

    /**
     * 请假人
     */
    private String leaverName;

    /**
     * 请假人部门id
     */
    private Long leaverDeptId;

    /**
     * 请假人部门
     */
    private String leaverDept;

    /**
     * 请假类型
     */
    private Integer leaveType;

    /**
     * 请假开始时间
     */
    private Date leaveStart;

    /**
     * 请假结束时间
     */
    private Date leaveEnd;

    /**
     * 请假天数
     */
    private Integer leaveDay;

    /**
     * 请假小时数
     */
    private Float leaveHour;

    /**
     * 审批结果
     */
    private Integer approveResult;

    /**
     * 理由
     */
    private String reason;

    /**
     * 主管意见
     */
    private String leaderOpinion;

    /**
     * 经理意见
     */
    private String managerOpinion;

    private static final long serialVersionUID = 6518011248511255552L;

    /**
     * 获取id
     *
     * @return form_id - id
     */
    public Long getFormId() {
        return formId;
    }

    /**
     * 设置id
     *
     * @param formId id
     */
    public void setFormId(Long formId) {
        this.formId = formId;
    }

    /**
     * 获取单号
     *
     * @return form_no - 单号
     */
    public Long getFormNo() {
        return formNo;
    }

    /**
     * 设置单号
     *
     * @param formNo 单号
     */
    public void setFormNo(Long formNo) {
        this.formNo = formNo;
    }

    /**
     * 获取请假人用户id
     *
     * @return leaver_id - 请假人用户id
     */
    public Long getLeaverId() {
        return leaverId;
    }

    /**
     * 设置请假人用户id
     *
     * @param leaverId 请假人用户id
     */
    public void setLeaverId(Long leaverId) {
        this.leaverId = leaverId;
    }

    /**
     * 获取请假人
     *
     * @return leaver_name - 请假人
     */
    public String getLeaverName() {
        return leaverName;
    }

    /**
     * 设置请假人
     *
     * @param leaverName 请假人
     */
    public void setLeaverName(String leaverName) {
        this.leaverName = leaverName;
    }

    /**
     * 获取请假人部门id
     *
     * @return leaver_dept_id - 请假人部门id
     */
    public Long getLeaverDeptId() {
        return leaverDeptId;
    }

    /**
     * 设置请假人部门id
     *
     * @param leaverDeptId 请假人部门id
     */
    public void setLeaverDeptId(Long leaverDeptId) {
        this.leaverDeptId = leaverDeptId;
    }

    /**
     * 获取请假人部门
     *
     * @return leaver_dept - 请假人部门
     */
    public String getLeaverDept() {
        return leaverDept;
    }

    /**
     * 设置请假人部门
     *
     * @param leaverDept 请假人部门
     */
    public void setLeaverDept(String leaverDept) {
        this.leaverDept = leaverDept;
    }

    /**
     * 获取请假类型
     *
     * @return leave_type - 请假类型
     */
    public Integer getLeaveType() {
        return leaveType;
    }

    /**
     * 设置请假类型
     *
     * @param leaveType 请假类型
     */
    public void setLeaveType(Integer leaveType) {
        this.leaveType = leaveType;
    }

    /**
     * 获取请假开始时间
     *
     * @return leave_start - 请假开始时间
     */
    public Date getLeaveStart() {
        return leaveStart;
    }

    /**
     * 设置请假开始时间
     *
     * @param leaveStart 请假开始时间
     */
    public void setLeaveStart(Date leaveStart) {
        this.leaveStart = leaveStart;
    }

    /**
     * 获取请假结束时间
     *
     * @return leave_end - 请假结束时间
     */
    public Date getLeaveEnd() {
        return leaveEnd;
    }

    /**
     * 设置请假结束时间
     *
     * @param leaveEnd 请假结束时间
     */
    public void setLeaveEnd(Date leaveEnd) {
        this.leaveEnd = leaveEnd;
    }

    /**
     * 获取请假天数
     *
     * @return leave_day - 请假天数
     */
    public Integer getLeaveDay() {
        return leaveDay;
    }

    /**
     * 设置请假天数
     *
     * @param leaveDay 请假天数
     */
    public void setLeaveDay(Integer leaveDay) {
        this.leaveDay = leaveDay;
    }

    /**
     * 获取请假小时数
     *
     * @return leave_hour - 请假小时数
     */
    public Float getLeaveHour() {
        return leaveHour;
    }

    /**
     * 设置请假小时数
     *
     * @param leaveHour 请假小时数
     */
    public void setLeaveHour(Float leaveHour) {
        this.leaveHour = leaveHour;
    }

    /**
     * 获取审批结果
     *
     * @return approve_result - 审批结果
     */
    public Integer getApproveResult() {
        return approveResult;
    }

    /**
     * 设置审批结果
     *
     * @param approveResult 审批结果
     */
    public void setApproveResult(Integer approveResult) {
        this.approveResult = approveResult;
    }

    /**
     * 获取理由
     *
     * @return reason - 理由
     */
    public String getReason() {
        return reason;
    }

    /**
     * 设置理由
     *
     * @param reason 理由
     */
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * 获取主管意见
     *
     * @return leader_opinion - 主管意见
     */
    public String getLeaderOpinion() {
        return leaderOpinion;
    }

    /**
     * 设置主管意见
     *
     * @param leaderOpinion 主管意见
     */
    public void setLeaderOpinion(String leaderOpinion) {
        this.leaderOpinion = leaderOpinion;
    }

    /**
     * 获取经理意见
     *
     * @return manager_opinion - 经理意见
     */
    public String getManagerOpinion() {
        return managerOpinion;
    }

    /**
     * 设置经理意见
     *
     * @param managerOpinion 经理意见
     */
    public void setManagerOpinion(String managerOpinion) {
        this.managerOpinion = managerOpinion;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", formId=").append(formId);
        sb.append(", formNo=").append(formNo);
        sb.append(", leaverId=").append(leaverId);
        sb.append(", leaverName=").append(leaverName);
        sb.append(", leaverDeptId=").append(leaverDeptId);
        sb.append(", leaverDept=").append(leaverDept);
        sb.append(", leaveType=").append(leaveType);
        sb.append(", leaveStart=").append(leaveStart);
        sb.append(", leaveEnd=").append(leaveEnd);
        sb.append(", leaveDay=").append(leaveDay);
        sb.append(", leaveHour=").append(leaveHour);
        sb.append(", approveResult=").append(approveResult);
        sb.append(", reason=").append(reason);
        sb.append(", leaderOpinion=").append(leaderOpinion);
        sb.append(", managerOpinion=").append(managerOpinion);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}