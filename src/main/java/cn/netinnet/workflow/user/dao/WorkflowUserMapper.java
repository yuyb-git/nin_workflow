/*
 * WorkflowUserMapper.java
 * Copyright(c) 2017-2018 厦门网中网软件有限公司
 * All right reserved.
 * 2020-03-06 Created
 */
package cn.netinnet.workflow.user.dao;

import cn.netinnet.workflow.common.base.BaseMapper;
import cn.netinnet.workflow.user.domain.WorkflowUser;
import cn.netinnet.workflow.user.domain.WorkflowUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface WorkflowUserMapper extends BaseMapper<WorkflowUser, WorkflowUserExample> {
	
	@Select("select * from workflow_user where username = #{userName}")
	WorkflowUser getWorkflowUserByName(@Param("userName") String userName);
	
}