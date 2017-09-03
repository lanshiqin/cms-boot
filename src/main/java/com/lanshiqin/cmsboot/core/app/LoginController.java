package com.lanshiqin.cmsboot.core.app;

import com.lanshiqin.cmsboot.core.api.JsonBaseController;
import com.lanshiqin.cmsboot.core.bean.JsonDataBean;
import com.lanshiqin.cmsboot.core.entity.SysLoginInfo;
import com.lanshiqin.cmsboot.core.entity.SysUserInfo;
import com.lanshiqin.cmsboot.core.filter.UserLoginFilter;
import com.lanshiqin.cmsboot.core.service.SysLoginInfoService;
import com.lanshiqin.cmsboot.core.service.SysUserInfoService;
import com.lanshiqin.cmsboot.core.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 登录控制器
 */
@Controller
public class LoginController extends JsonBaseController {

    @Autowired
    private SysLoginInfoService sysLoginInfoService;    // 登录服务

    @Autowired
    private SysUserInfoService sysUserInfoService;      // 用户信息服务

    /**
     * 跳转到login登录页面
     * @return 登录页面模板视图
     */
    @RequestMapping("/login")
    public String toLogin(){
        return "login";
    }

    /**
     * 登录动作
     * @param userLoginFilter 登录信息过滤器
     * @return 登录成功或者失败的json数据
     */
    @RequestMapping(value = "/login.action", method = RequestMethod.POST)
    @ResponseBody
    public JsonDataBean loginAction(UserLoginFilter userLoginFilter){

        String userName = userLoginFilter.getUserName();
        String passWord = userLoginFilter.getPassWord();

        if (ObjectUtils.isBlank(userName)){
            return getJsonDataBean("500","用户名不能为空");
        }
        if (ObjectUtils.isBlank(passWord)){
            return getJsonDataBean("500","密码不能为空");
        }

        // 根据用户名查找用户信息
        SysLoginInfo sysLoginInfo = sysLoginInfoService.findByUserName(userLoginFilter);

        // 判断用户信息是否为空
        if (ObjectUtils.isNotBlank(sysLoginInfo)){

            // 对比用户的密码和数据库中的密码是否一致
            if (passWord.equals(sysLoginInfo.getPassWord())){

                // 根据用户id查找用户信息
                SysUserInfo sysUserInfo = sysUserInfoService.findById(sysLoginInfo.getUserId());
                if (ObjectUtils.isNotBlank(sysUserInfo)){
                    return getJsonDataBean("200","登录成功",sysUserInfo);
                }else{
                    return getJsonDataBean("500","用户信息不存在","账号异常!");
                }

            }
            return getJsonDataBean("500","用户名或密码错误");
        }
        return getJsonDataBean("500","用户名或密码错误");
    }

}
