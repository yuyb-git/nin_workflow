package cn.netinnet.workflow.user.service.impl;

import cn.netinnet.workflow.common.base.BaseService;
import cn.netinnet.workflow.user.dao.WorkflowRoleMapper;
import cn.netinnet.workflow.user.domain.WorkflowRole;
import cn.netinnet.workflow.user.domain.WorkflowRoleExample;
import cn.netinnet.workflow.user.service.WorkflowRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * @author yuyb
 * @date   2020-03-06
 */
@Service
public class WorkflowRoleServiceImpl extends BaseService<WorkflowRole,WorkflowRoleExample> implements WorkflowRoleService {
    @Resource
    private WorkflowRoleMapper workflowRoleMapper;

    @Override
    public int insertSelective(WorkflowRole workflowRole, long userId) {
        return workflowRoleMapper.insertSelective(workflowRole);
    }
    @Override
    public Class getClazz(){
        return WorkflowRole.class;
    }
}