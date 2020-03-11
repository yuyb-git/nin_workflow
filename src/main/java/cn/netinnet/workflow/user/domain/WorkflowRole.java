/*
 * WorkflowRole.java
 * Copyright(c) 2017-2018 厦门网中网软件有限公司
 * All right reserved.
 * 2020-03-06 Created
 */
package cn.netinnet.workflow.user.domain;

import java.io.Serializable;
import java.util.Set;

/**
 * @author admin
 * @date   2020-03-06
 **/
public class WorkflowRole implements Serializable {
    private Long roleId;

    private String roleCode;

    private String roleName;
    
    private Set<WorkflowPermission> permissions;

    private static final long serialVersionUID = 8332465084433347584L;

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

    public Set<WorkflowPermission> getPermissions() {
		return permissions;
	}

	public void setPermissions(Set<WorkflowPermission> permissions) {
		this.permissions = permissions;
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
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}