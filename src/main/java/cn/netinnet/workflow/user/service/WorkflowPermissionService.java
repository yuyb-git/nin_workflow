package cn.netinnet.workflow.user.service;


import cn.netinnet.workflow.common.base.Service;
import cn.netinnet.workflow.user.domain.WorkflowPermission;
import cn.netinnet.workflow.user.domain.WorkflowPermissionExample;

import java.util.List;
import java.util.Map;

/**
 * @author yuyb
 * @date   2020-03-06
 */
public interface WorkflowPermissionService  extends Service<WorkflowPermission, WorkflowPermissionExample> {
    /** 方法描述
     * @description 资源权限树
     * @param userPermission
     * @param type
     * @param userHasPermission
     * @return [userPermission, type, userHasPermission]
     * @author wanghy
     * @date 2020/4/1 15:37
     */
    List<Map<String, Object>> getTree (List<WorkflowPermission> userPermission,
                                       Integer type,
                                       List<String> userHasPermission);
}
