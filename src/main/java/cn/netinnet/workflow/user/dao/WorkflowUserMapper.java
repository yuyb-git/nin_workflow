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
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface WorkflowUserMapper extends BaseMapper<WorkflowUser, WorkflowUserExample> {
	
	/**
	 * @Author yuyb
	 * @Description 根据用户名查询用户
	 * @Date 16:10 2020/3/12
	 * @param userName
	 * @return cn.netinnet.workflow.user.domain.WorkflowUser
	 **/
	@Select("select * from workflow_user where username = #{userName}")
	WorkflowUser getWorkflowUserByName(@Param("userName") String userName);

	/**
	 * @Author yuyb
	 * @Description 
	 * @Date 16:11 2020/3/12
	 * @param 
	 * @return java.util.List<cn.netinnet.workflow.user.domain.WorkflowUser>
	 **/
	@Select("select * from workflow_user")
	List<WorkflowUser> selectAllUser();
	
}