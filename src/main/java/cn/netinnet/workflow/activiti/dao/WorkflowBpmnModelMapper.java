/*
 * WorkflowBpmnModelMapper.java
 * Copyright(c) 2017-2018 厦门网中网软件有限公司
 * All right reserved.
 * 2020-03-13 Created
 */
package cn.netinnet.workflow.activiti.dao;

import cn.netinnet.workflow.activiti.domain.WorkflowBpmnModel;
import cn.netinnet.workflow.activiti.domain.WorkflowBpmnModelExample;
import cn.netinnet.workflow.common.base.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WorkflowBpmnModelMapper extends BaseMapper<WorkflowBpmnModel, WorkflowBpmnModelExample> {
}