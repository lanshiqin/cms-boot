package com.lanshiqin.cmsboot.core.filter;

/**
 * 角色信息查询过滤器
 */
public class RoleInfoFilter {
    private String name;    // 角色名称
    private String type;    // 角色类型

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
