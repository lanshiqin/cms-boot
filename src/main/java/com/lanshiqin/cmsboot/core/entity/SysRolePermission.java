package com.lanshiqin.cmsboot.core.entity;

/**
 * 角色权限实体类
 */
public class SysRolePermission extends LongEntity {
    private String roleId;  // 角色id
    private String permId;  // 权限id

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getPermId() {
        return permId;
    }

    public void setPermId(String permId) {
        this.permId = permId;
    }
}
