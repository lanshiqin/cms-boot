package com.lanshiqin.cmsboot.core.entity;

/**
 * 权限信息实体类
 */
public class SysPermissionInfo extends LongEntity {
    private String func;    // 方法权限字符（或者url地址）
    private String name;    // 方法描述（url地址描述）

    public String getFunc() {
        return func;
    }

    public void setFunc(String func) {
        this.func = func;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
