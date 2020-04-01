package cn.netinnet.workflow.config.shiroconfig;


import cn.netinnet.workflow.user.dao.WorkflowRoleMapper;
import cn.netinnet.workflow.user.dao.WorkflowUserMapper;
import cn.netinnet.workflow.user.domain.WorkflowRole;
import cn.netinnet.workflow.user.domain.WorkflowUser;
import cn.netinnet.workflow.util.MD5Utils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Copyright © 厦门网中网软件有限公司.
 *
 * @author wanghy
 * @version 1.0
 * @description
 * @date 2020/2/27 13:36
 */
public class ShiroRealm extends AuthorizingRealm {
    Logger logger = LoggerFactory.getLogger(ShiroRealm.class);

    @Resource
    WorkflowRoleMapper workflowRoleMapper;
    @Resource
    WorkflowUserMapper workflowUserMapper;

    @Override
    public String getName() {
        return "shiroReaml";
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        // 获取用户
        List key =  principalCollection.asList();
        Map<String, Object> user = new HashMap<>();

        try {
            if (key.size() > 0) {
                user = BeanUtils.describe(key.get(0));
            } else {
                return null;
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        String roleCode = user.get("roleCode").toString();

        // 这里进行授权和处理

        WorkflowRole workflowRole = workflowRoleMapper.getRolePermissionByCode(roleCode);
        String roleName = workflowRole.getRoleName();

        authorizationInfo.addRole(roleName);

        String permissions = workflowRole.getRolePermission();
        String[] permissionStr = permissions.split(",");
        for (String right : permissionStr) {
            authorizationInfo.addStringPermission(right);
        }
        logger.info("赋予角色和权限成功！");

        return authorizationInfo;
    }

    /** 方法描述
     * @description 身份认证
     * @param authenticationToken
     * @return [authenticationToken]
     * @author wanghy
     * @date 2020/2/27 13:46
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken tokenInfo = (UsernamePasswordToken) authenticationToken;
        // 获取用户输入的账号
        String userName = tokenInfo.getUsername();
        // 获取用户输入的密码
        String password = String.valueOf(tokenInfo.getPassword());

        // 进行验证
        WorkflowUser workflowUser = workflowUserMapper.getWorkflowUserByName(userName);
        if (workflowUser == null) {
            return null;
        }

        if (!MD5Utils.getSaltverifyMD5(password, workflowUser.getPassword())) {
            throw new IncorrectCredentialsException("用户名或密码错误!");
        }

        return new SimpleAuthenticationInfo(workflowUser, password, ByteSource.Util.bytes(userName), getName());

    }

}
