package com.lanshiqin.cmsboot.core.security;

/**
 * 用户名和密码令牌类
 */
public class UsernamePasswordToken extends org.apache.shiro.authc.UsernamePasswordToken {

    public UsernamePasswordToken(String userName, String passWord) {
        super(userName,passWord);
    }
}
