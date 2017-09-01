package com.lanshiqin.cmsboot.core.app;

import com.lanshiqin.cmsboot.core.api.JsonBaseController;
import com.lanshiqin.cmsboot.core.bean.JsonDataBean;
import com.lanshiqin.cmsboot.core.filter.UserLoginFilter;
import com.lanshiqin.cmsboot.core.utils.ObjectUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 登录控制器
 */
@Controller
public class LoginController extends JsonBaseController {

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

        if (userName.equals("admin")&&passWord.equals("admin123")){
            return getJsonDataBean("200","登录成功","欢迎用户"+userName);
        }
        return getJsonDataBean("500","用户名或密码错误");
    }

}
