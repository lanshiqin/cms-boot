package com.lanshiqin.cmsboot.core.entity;

/**
 * 部门信息实体类
 */
public class SysDepInfo extends LongEntity {
    private String name;        // 部门名称
    private Integer level;      // 部门级别
    private String relation;    // 部门关系
    private String status;      // 部门状态（1：正常，0：禁用）

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
