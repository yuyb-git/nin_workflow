package cn.netinnet.workflow.activiti.service.impl;

import cn.netinnet.workflow.common.base.BaseService;
import cn.netinnet.workflow.activiti.dao.WorkflowBpmnModelMapper;
import cn.netinnet.workflow.activiti.domain.WorkflowBpmnModel;
import cn.netinnet.workflow.activiti.domain.WorkflowBpmnModelExample;
import cn.netinnet.workflow.activiti.service.WorkflowBpmnModelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * @author yuyb
 * @date   2020-03-13
 */
@Service
public class WorkflowBpmnModelServiceImpl extends BaseService<WorkflowBpmnModel,WorkflowBpmnModelExample> implements WorkflowBpmnModelService {
    @Resource
    private WorkflowBpmnModelMapper workflowBpmnModelMapper;

    @Override
    public int insertSelective(WorkflowBpmnModel workflowBpmnModel, long userId) {
        return workflowBpmnModelMapper.insertSelective(workflowBpmnModel);
    }
    @Override
    public Class getClazz(){
        return WorkflowBpmnModel.class;
    }
}