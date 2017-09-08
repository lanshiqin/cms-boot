package com.lanshiqin.cmsboot.core.entity;

/**
 * 登录信息实体类
 */
public class SysLoginInfo extends LongEntity {
    private String userName;    // 用户名
    private String passWord;    // 密码
    private Long userId;        // 用户信息表id
    private String status;      // 账号状态（1：正常，0：禁用）

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
