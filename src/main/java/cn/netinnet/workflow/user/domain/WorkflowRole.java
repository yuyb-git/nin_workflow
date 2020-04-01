/*
 * WorkflowRole.java
 * Copyright(c) 2017-2018 厦门网中网软件有限公司
 * All right reserved.
 * 2020-03-12 Created
 */
package cn.netinnet.workflow.user.domain;

import java.io.Serializable;

/**
 * @author admin
 * @date   2020-03-12
 **/
public class WorkflowRole implements Serializable {
    private Long roleId;

    private String roleCode;

    private String roleName;

    /**
     * 角色权限
     */
    private String rolePermission;

    private static final long serialVersionUID = 3912049177494724608L;

    /**
     * @return role_id
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * @param roleId
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * @return role_code
     */
    public String getRoleCode() {
        return roleCode;
    }

    /**
     * @param roleCode
     */
    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    /**
     * @return role_name
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * @param roleName
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * 获取角色权限
     *
     * @return role_permission - 角色权限
     */
    public String getRolePermission() {
        return rolePermission;
    }

    /**
     * 设置角色权限
     *
     * @param rolePermission 角色权限
     */
    public void setRolePermission(String rolePermission) {
        this.rolePermission = rolePermission;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", roleId=").append(roleId);
        sb.append(", roleCode=").append(roleCode);
        sb.append(", roleName=").append(roleName);
        sb.append(", rolePermission=").append(rolePermission);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}