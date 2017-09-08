package com.lanshiqin.cmsboot.core.filter;

/**
 * 用户信息查询过滤器
 */
public class UserInfoFilter {
    private Integer sysId; // 用户id
    private String nick;        // 昵称
    private String sex;         // 性别
    private String birthday;    // 生日

    private String userName;    // 用户名
    private String passWord;    // 密码
    private String status;      // 账号状态（1：正常，0：禁用）


    public Integer getSysId() {
        return sysId;
    }

    public void setSysId(Integer sysId) {
        this.sysId = sysId;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
