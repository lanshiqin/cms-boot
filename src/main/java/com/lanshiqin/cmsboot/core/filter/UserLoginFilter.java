package com.lanshiqin.cmsboot.core.filter;

/**
 * 用户登录过滤器
 */
public class UserLoginFilter {
    private String userName;    // 用户名
    private String passWord;    // 密码

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
}
