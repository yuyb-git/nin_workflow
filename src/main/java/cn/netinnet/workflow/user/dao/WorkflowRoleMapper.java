/*
 * WorkflowRoleMapper.java
 * Copyright(c) 2017-2018 厦门网中网软件有限公司
 * All right reserved.
 * 2020-03-06 Created
 */
package cn.netinnet.workflow.user.dao;


import cn.netinnet.workflow.common.base.BaseMapper;
import cn.netinnet.workflow.user.domain.WorkflowRole;
import cn.netinnet.workflow.user.domain.WorkflowRoleExample;
import org.apache.ibatis.annotations.Param;

public interface WorkflowRoleMapper extends BaseMapper<WorkflowRole, WorkflowRoleExample> {
    /** 方法描述
     * @description 根据roleCode获取角色的权限信息
     * @param roleCode
     * @return [roleCode]
     * @author wanghy
     * @date 2020/3/12 14:01
     */
    WorkflowRole getRolePermissionByCode(@Param("roleCode") String roleCode);
}