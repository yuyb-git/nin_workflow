/*
 * WorkflowBpmnModel.java
 * Copyright(c) 2017-2018 厦门网中网软件有限公司
 * All right reserved.
 * 2020-03-13 Created
 */
package cn.netinnet.workflow.activiti.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author admin
 * @date   2020-03-13
 **/
public class WorkflowBpmnModel implements Serializable {
    /**
     * 模型id，主键
     */
    private Long modelId;

    /**
     * 模型名称
     */
    private String modelName;

    /**
     * act_re_model的主键id
     */
    private String activitiModelId;

    /**
     * bpmn流程图路径
     */
    private String bpmnImgae;

    /**
     * bpmn模板路径
     */
    private String bpmnXml;

    /**
     * 创建人
     */
    private Long createUserId;

    /**
     * 创建时间
     */
    private Date createTime;

    private static final long serialVersionUID = 5141675144739844096L;

    /**
     * 获取模型id，主键
     *
     * @return model_id - 模型id，主键
     */
    public Long getModelId() {
        return modelId;
    }

    /**
     * 设置模型id，主键
     *
     * @param modelId 模型id，主键
     */
    public void setModelId(Long modelId) {
        this.modelId = modelId;
    }

    /**
     * 获取模型名称
     *
     * @return model_name - 模型名称
     */
    public String getModelName() {
        return modelName;
    }

    /**
     * 设置模型名称
     *
     * @param modelName 模型名称
     */
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    /**
     * 获取act_re_model的主键id
     *
     * @return activiti_model_id - act_re_model的主键id
     */
    public String getActivitiModelId() {
        return activitiModelId;
    }

    /**
     * 设置act_re_model的主键id
     *
     * @param activitiModelId act_re_model的主键id
     */
    public void setActivitiModelId(String activitiModelId) {
        this.activitiModelId = activitiModelId;
    }

    /**
     * 获取bpmn流程图路径
     *
     * @return bpmn_imgae - bpmn流程图路径
     */
    public String getBpmnImgae() {
        return bpmnImgae;
    }

    /**
     * 设置bpmn流程图路径
     *
     * @param bpmnImgae bpmn流程图路径
     */
    public void setBpmnImgae(String bpmnImgae) {
        this.bpmnImgae = bpmnImgae;
    }

    /**
     * 获取bpmn模板路径
     *
     * @return bpmn_xml - bpmn模板路径
     */
    public String getBpmnXml() {
        return bpmnXml;
    }

    /**
     * 设置bpmn模板路径
     *
     * @param bpmnXml bpmn模板路径
     */
    public void setBpmnXml(String bpmnXml) {
        this.bpmnXml = bpmnXml;
    }

    /**
     * 获取创建人
     *
     * @return create_user_id - 创建人
     */
    public Long getCreateUserId() {
        return createUserId;
    }

    /**
     * 设置创建人
     *
     * @param createUserId 创建人
     */
    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", modelId=").append(modelId);
        sb.append(", modelName=").append(modelName);
        sb.append(", activitiModelId=").append(activitiModelId);
        sb.append(", bpmnImgae=").append(bpmnImgae);
        sb.append(", bpmnXml=").append(bpmnXml);
        sb.append(", createUserId=").append(createUserId);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}