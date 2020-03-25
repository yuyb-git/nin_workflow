/*
 * FormMaterial.java
 * Copyright(c) 2017-2018 厦门网中网软件有限公司
 * All right reserved.
 * 2020-03-25 Created
 */
package cn.netinnet.workflow.activiti.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author admin
 * @date   2020-03-25
 **/
public class FormMaterial implements Serializable {
    /**
     * 主键id
     */
    private Long formId;

    /**
     * 申请标题
     */
    private String formTitle;

    /**
     * 核算公司
     */
    private String accountCompany;

    /**
     * 申请用途
     */
    private String application;

    /**
     * 填单人
     */
    private String filler;

    /**
     * 填单日期
     */
    private Date fillDate;

    /**
     * 申请人用户id
     */
    private Long applierId;

    /**
     * 申请人
     */
    private String applierName;

    /**
     * 申请人电话
     */
    private String applierTel;

    /**
     * 申请人部门id
     */
    private Long applierDeptId;

    /**
     * 申请人部门
     */
    private String applierDept;

    /**
     * 到货期限
     */
    private Date arrivalDate;

    /**
     * 审批人用户id
     */
    private Long approverId;

    /**
     * 审批人
     */
    private String approverName;

    /**
     * 审批人部门id
     */
    private Long approverDeptId;

    /**
     * 审批人部门
     */
    private String approverDept;

    /**
     * 审批意见
     */
    private String approveOpinion;

    /**
     * 审批日期
     */
    private Date approveDate;

    private static final long serialVersionUID = 7264450502716409856L;

    /**
     * 获取主键id
     *
     * @return form_id - 主键id
     */
    public Long getFormId() {
        return formId;
    }

    /**
     * 设置主键id
     *
     * @param formId 主键id
     */
    public void setFormId(Long formId) {
        this.formId = formId;
    }

    /**
     * 获取申请标题
     *
     * @return form_title - 申请标题
     */
    public String getFormTitle() {
        return formTitle;
    }

    /**
     * 设置申请标题
     *
     * @param formTitle 申请标题
     */
    public void setFormTitle(String formTitle) {
        this.formTitle = formTitle;
    }

    /**
     * 获取核算公司
     *
     * @return account_company - 核算公司
     */
    public String getAccountCompany() {
        return accountCompany;
    }

    /**
     * 设置核算公司
     *
     * @param accountCompany 核算公司
     */
    public void setAccountCompany(String accountCompany) {
        this.accountCompany = accountCompany;
    }

    /**
     * 获取申请用途
     *
     * @return application - 申请用途
     */
    public String getApplication() {
        return application;
    }

    /**
     * 设置申请用途
     *
     * @param application 申请用途
     */
    public void setApplication(String application) {
        this.application = application;
    }

    /**
     * 获取填单人
     *
     * @return filler - 填单人
     */
    public String getFiller() {
        return filler;
    }

    /**
     * 设置填单人
     *
     * @param filler 填单人
     */
    public void setFiller(String filler) {
        this.filler = filler;
    }

    /**
     * 获取填单日期
     *
     * @return fill_date - 填单日期
     */
    public Date getFillDate() {
        return fillDate;
    }

    /**
     * 设置填单日期
     *
     * @param fillDate 填单日期
     */
    public void setFillDate(Date fillDate) {
        this.fillDate = fillDate;
    }

    /**
     * 获取申请人用户id
     *
     * @return applier_id - 申请人用户id
     */
    public Long getApplierId() {
        return applierId;
    }

    /**
     * 设置申请人用户id
     *
     * @param applierId 申请人用户id
     */
    public void setApplierId(Long applierId) {
        this.applierId = applierId;
    }

    /**
     * 获取申请人
     *
     * @return applier_name - 申请人
     */
    public String getApplierName() {
        return applierName;
    }

    /**
     * 设置申请人
     *
     * @param applierName 申请人
     */
    public void setApplierName(String applierName) {
        this.applierName = applierName;
    }

    /**
     * 获取申请人电话
     *
     * @return applier_tel - 申请人电话
     */
    public String getApplierTel() {
        return applierTel;
    }

    /**
     * 设置申请人电话
     *
     * @param applierTel 申请人电话
     */
    public void setApplierTel(String applierTel) {
        this.applierTel = applierTel;
    }

    /**
     * 获取申请人部门id
     *
     * @return applier_dept_id - 申请人部门id
     */
    public Long getApplierDeptId() {
        return applierDeptId;
    }

    /**
     * 设置申请人部门id
     *
     * @param applierDeptId 申请人部门id
     */
    public void setApplierDeptId(Long applierDeptId) {
        this.applierDeptId = applierDeptId;
    }

    /**
     * 获取申请人部门
     *
     * @return applier_dept - 申请人部门
     */
    public String getApplierDept() {
        return applierDept;
    }

    /**
     * 设置申请人部门
     *
     * @param applierDept 申请人部门
     */
    public void setApplierDept(String applierDept) {
        this.applierDept = applierDept;
    }

    /**
     * 获取到货期限
     *
     * @return arrival_date - 到货期限
     */
    public Date getArrivalDate() {
        return arrivalDate;
    }

    /**
     * 设置到货期限
     *
     * @param arrivalDate 到货期限
     */
    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    /**
     * 获取审批人用户id
     *
     * @return approver_id - 审批人用户id
     */
    public Long getApproverId() {
        return approverId;
    }

    /**
     * 设置审批人用户id
     *
     * @param approverId 审批人用户id
     */
    public void setApproverId(Long approverId) {
        this.approverId = approverId;
    }

    /**
     * 获取审批人
     *
     * @return approver_name - 审批人
     */
    public String getApproverName() {
        return approverName;
    }

    /**
     * 设置审批人
     *
     * @param approverName 审批人
     */
    public void setApproverName(String approverName) {
        this.approverName = approverName;
    }

    /**
     * 获取审批人部门id
     *
     * @return approver_dept_id - 审批人部门id
     */
    public Long getApproverDeptId() {
        return approverDeptId;
    }

    /**
     * 设置审批人部门id
     *
     * @param approverDeptId 审批人部门id
     */
    public void setApproverDeptId(Long approverDeptId) {
        this.approverDeptId = approverDeptId;
    }

    /**
     * 获取审批人部门
     *
     * @return approver_dept - 审批人部门
     */
    public String getApproverDept() {
        return approverDept;
    }

    /**
     * 设置审批人部门
     *
     * @param approverDept 审批人部门
     */
    public void setApproverDept(String approverDept) {
        this.approverDept = approverDept;
    }

    /**
     * 获取审批意见
     *
     * @return approve_opinion - 审批意见
     */
    public String getApproveOpinion() {
        return approveOpinion;
    }

    /**
     * 设置审批意见
     *
     * @param approveOpinion 审批意见
     */
    public void setApproveOpinion(String approveOpinion) {
        this.approveOpinion = approveOpinion;
    }

    /**
     * 获取审批日期
     *
     * @return approve_date - 审批日期
     */
    public Date getApproveDate() {
        return approveDate;
    }

    /**
     * 设置审批日期
     *
     * @param approveDate 审批日期
     */
    public void setApproveDate(Date approveDate) {
        this.approveDate = approveDate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", formId=").append(formId);
        sb.append(", formTitle=").append(formTitle);
        sb.append(", accountCompany=").append(accountCompany);
        sb.append(", application=").append(application);
        sb.append(", filler=").append(filler);
        sb.append(", fillDate=").append(fillDate);
        sb.append(", applierId=").append(applierId);
        sb.append(", applierName=").append(applierName);
        sb.append(", applierTel=").append(applierTel);
        sb.append(", applierDeptId=").append(applierDeptId);
        sb.append(", applierDept=").append(applierDept);
        sb.append(", arrivalDate=").append(arrivalDate);
        sb.append(", approverId=").append(approverId);
        sb.append(", approverName=").append(approverName);
        sb.append(", approverDeptId=").append(approverDeptId);
        sb.append(", approverDept=").append(approverDept);
        sb.append(", approveOpinion=").append(approveOpinion);
        sb.append(", approveDate=").append(approveDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}