package com.lanshiqin.cmsboot.core.api;

import com.google.gson.Gson;
import com.lanshiqin.cmsboot.core.bean.JsonDataBean;
import com.lanshiqin.cmsboot.core.entity.SysLoginInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 角色权限接口控制器
 */
@RestController
public class SysRolePermissionApiController extends JsonBaseController {


    @Autowired
    private RedisTemplate<String, String> redisTemplate;        // 缓存模板对象

    /**
     * 角色权限信息接口
     * @return 角色权限集合
     */
    @RequestMapping(value = "/getRolePermission")
    public JsonDataBean getRolePermission(){

        // 获取用户信息
        SysLoginInfo sysLoginInfo = (SysLoginInfo) SecurityUtils.getSubject().getPrincipal();

        // 从redis中获取用户认证信息
        String info = redisTemplate.opsForValue().get(String.valueOf(sysLoginInfo.getUserId()));

        SimpleAuthorizationInfo simpleAuthorizationInfo = new Gson().fromJson(info,SimpleAuthorizationInfo.class);

        return getJsonDataBean("200","权限信息",simpleAuthorizationInfo.getStringPermissions());
    }
}
