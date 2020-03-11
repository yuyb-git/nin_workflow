package cn.netinnet.workflow.user.service.impl;

import cn.netinnet.workflow.common.base.BaseService;
import cn.netinnet.workflow.user.dao.WorkflowUserMapper;
import cn.netinnet.workflow.user.domain.WorkflowUser;
import cn.netinnet.workflow.user.domain.WorkflowUserExample;
import cn.netinnet.workflow.user.service.WorkflowUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * @author yuyb
 * @date   2020-03-06
 */
@Service
public class WorkflowUserServiceImpl extends BaseService<WorkflowUser,WorkflowUserExample> implements WorkflowUserService {
    @Resource
    private WorkflowUserMapper workflowUserMapper;

    @Override
    public int insertSelective(WorkflowUser workflowUser, long userId) {
        return workflowUserMapper.insertSelective(workflowUser);
    }
    @Override
    public Class getClazz(){
        return WorkflowUser.class;
    }
    
    @Override
    public WorkflowUser getWorkflowUserByName(String userName) {
    	return workflowUserMapper.getWorkflowUserByName(userName);
    }
    
}