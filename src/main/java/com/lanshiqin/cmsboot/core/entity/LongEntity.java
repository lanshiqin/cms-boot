package com.lanshiqin.cmsboot.core.entity;

/**
 * 主键为长整型的实体基类
 */
public class LongEntity extends BaseEntity {
    private Long sysId;

    public Long getSysId() {
        return sysId;
    }

    public void setSysId(Long sysId) {
        this.sysId = sysId;
    }
}
