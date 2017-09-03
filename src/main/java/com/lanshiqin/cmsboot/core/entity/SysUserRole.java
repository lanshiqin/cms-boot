package com.lanshiqin.cmsboot.core.entity;

/**
 * 用户角色实体类
 */
public class SysUserRole extends LongEntity {
    private String userId;  // 用户id
    private String roleId;  // 角色id

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}
