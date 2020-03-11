package cn.netinnet.workflow.user.service.impl;

import cn.netinnet.workflow.common.base.BaseService;
import cn.netinnet.workflow.user.dao.WorkflowPermissionMapper;
import cn.netinnet.workflow.user.domain.WorkflowPermission;
import cn.netinnet.workflow.user.domain.WorkflowPermissionExample;
import cn.netinnet.workflow.user.service.WorkflowPermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * @author yuyb
 * @date   2020-03-06
 */
@Service
public class WorkflowPermissionServiceImpl extends BaseService<WorkflowPermission,WorkflowPermissionExample> implements WorkflowPermissionService {
    @Resource
    private WorkflowPermissionMapper workflowPermissionMapper;

    @Override
    public int insertSelective(WorkflowPermission workflowPermission, long userId) {
        return workflowPermissionMapper.insertSelective(workflowPermission);
    }
    @Override
    public Class getClazz(){
        return WorkflowPermission.class;
    }
}