/*
 * WorkflowPermissionMapper.java
 * Copyright(c) 2017-2018 厦门网中网软件有限公司
 * All right reserved.
 * 2020-03-06 Created
 */
package cn.netinnet.workflow.user.dao;

import cn.netinnet.workflow.common.base.BaseMapper;
import cn.netinnet.workflow.user.domain.WorkflowPermission;
import cn.netinnet.workflow.user.domain.WorkflowPermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WorkflowPermissionMapper extends BaseMapper<WorkflowPermission, WorkflowPermissionExample> {
}