package cn.netinnet.workflow.user.service;

import cn.netinnet.workflow.common.base.Service;
import cn.netinnet.workflow.user.domain.WorkflowUser;
import cn.netinnet.workflow.user.domain.WorkflowUserExample;


/**
 * @author yuyb
 * @date   2020-03-06
 */
public interface WorkflowUserService  extends Service<WorkflowUser,WorkflowUserExample>{
	
	public WorkflowUser getWorkflowUserByName(String userName);

}
