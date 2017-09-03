package com.lanshiqin.cmsboot.core.entity;

/**
 * 主键为字符串类型的实体基类
 */
public class StringEntity extends BaseEntity {
    private String sysId;   // 主键

    public String getSysId() {
        return sysId;
    }

    public void setSysId(String sysId) {
        this.sysId = sysId;
    }
}
