package cn.netinnet.workflow.user.service.impl;

import cn.netinnet.workflow.common.base.BaseService;
import cn.netinnet.workflow.user.dao.WorkflowPermissionMapper;
import cn.netinnet.workflow.user.domain.WorkflowPermission;
import cn.netinnet.workflow.user.domain.WorkflowPermissionExample;
import cn.netinnet.workflow.user.service.WorkflowPermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


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

    /** 方法描述
     * @description 资源权限树
     * @param userPermission
     * @param type
     * @param userHasPermission
     * @return [userPermission, type, userHasPermission]
     * @author wanghy
     * @date 2020/4/1 15:37
     */
    @Override
    public List<Map<String, Object>> getTree (List<WorkflowPermission> userPermission,
                                             Integer type,
                                             List<String> userHasPermission) {
        List<Map<String, Object>> resultJson = new ArrayList<>();
        List<WorkflowPermission> fsscResourcesNext;


        List<WorkflowPermission> totalUserResource = workflowPermissionMapper.selectByExample(null);

        Map<String, List<WorkflowPermission>> groupUserResourceMap = totalUserResource.stream().
                collect(Collectors.groupingBy(item -> item.getParentId().toString()));

        for (WorkflowPermission resource : userPermission) {
            Map<String, Object> result = new HashMap<>();
            result.put("name", resource.getPermissionName());
            result.put("value", resource.getPermission());

            if (type != 1) {
                if (userHasPermission.contains(resource.getPermission())) {
                    result.put("checked", true);
                } else {
                    result.put("checked", false);
                }
            } else {
                result.put("checked", false);
            }

            // 获得之后的层级
            fsscResourcesNext = groupUserResourceMap.get(resource.getPermissionId().toString());

            if (fsscResourcesNext != null && !fsscResourcesNext.isEmpty()) {
                result.put("list", getTree(fsscResourcesNext, type, userHasPermission));
                resultJson.add(result);
            } else {
                resultJson.add(result);
            }
        }


        return resultJson;
    }
}