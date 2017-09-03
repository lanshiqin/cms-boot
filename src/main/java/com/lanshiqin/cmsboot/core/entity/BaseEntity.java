package com.lanshiqin.cmsboot.core.entity;

import java.io.Serializable;

/**
 * 实体基类
 */
public class BaseEntity implements Serializable {
    private String createDate;  // 创建日期
    private String createTime;  // 创建时间
    private String createUser;  // 创建用户
    private String updateDate;  // 更新日期
    private String updateTime;  // 更新时间
    private String updateUser;  // 更新用户

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }
}
