package com.lanshiqin.cmsboot.core.security;

import com.google.gson.Gson;
import com.lanshiqin.cmsboot.core.entity.*;
import com.lanshiqin.cmsboot.core.service.*;
import com.lanshiqin.cmsboot.core.utils.ObjectUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 系统安全认证类
 */
@Service
public class SystemAuthorizingRealm extends AuthorizingRealm {

    @Autowired
    private SysLoginInfoService sysLoginInfoService;            // 系统登录服务

    @Autowired
    private SysUserRoleService sysUserRoleService;              // 用户角色服务

    @Autowired
    private SysRoleInfoService sysRoleInfoService;              // 角色信息服务

    @Autowired
    private SysRolePermissionService sysRolePermissionService;  // 角色权限服务

    @Autowired
    private SysPermissionInfoService sysPermissionInfoService;  // 权限信息服务

    @Autowired
    private RedisTemplate<String, String> redisTemplate;        // 缓存模板对象
    /**
     * 授权(权限认证）
     *
     * @param principals principals
     * @return AuthorizationInfo
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        // 登录信息
        SysLoginInfo sysLoginInfo = (SysLoginInfo) SecurityUtils.getSubject().getPrincipal();

        // 获取用户id
        Long userId = sysLoginInfo.getUserId();

        // 认证信息实体
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        // 根据用户id获取用户角色id
        List<SysUserRole> sysUserRoleList = sysUserRoleService.findByUserID(userId);

        if (ObjectUtils.isBlank(sysUserRoleList)){
            return info;
        }

        List<String> roleIdList = new ArrayList<>();
        for (SysUserRole userRole : sysUserRoleList) {
            roleIdList.add(userRole.getRoleId());
        }
        List<SysRoleInfo> sysRoleInfoList = sysRoleInfoService.findByIn(roleIdList);

        if (ObjectUtils.isBlank(sysRoleInfoList)){
            return info;
        }
        // 添加角色
        Set<String> roleSet = new HashSet<>();
        for (SysRoleInfo sysRoleInfo : sysRoleInfoList) {
            roleSet.add(sysRoleInfo.getType()); // 角色类别
        }
        info.setRoles(roleSet); // 设置角色


        // 根据角色id获取角色权限id
        List<SysRolePermission> sysRolePermissionList = sysRolePermissionService.findByIn(roleIdList);

        if (ObjectUtils.isBlank(sysRolePermissionList)){
            return info;
        }

        List<String> permissionIdList = new ArrayList<>();
        for (SysRolePermission sysRolePermission: sysRolePermissionList){
            permissionIdList.add(sysRolePermission.getPermId());
        }
        List<SysPermissionInfo> sysPermissionInfoList = sysPermissionInfoService.findByIn(permissionIdList);

        if (ObjectUtils.isBlank(sysPermissionInfoList)){
            return info;
        }

        // 添加权限
        Set<String> permissionSet = new HashSet<>();
        for (SysPermissionInfo sysPermissionInfo: sysPermissionInfoList){
            permissionSet.add(sysPermissionInfo.getFunc()); // 权限字符
        }
        info.setStringPermissions(permissionSet);

        // 将用户认证信息存到redis中
        redisTemplate.opsForValue().set(String.valueOf(userId),new Gson().toJson(info));

        return info;
    }

    /**
     * 身份认证
     *
     * @param token token
     * @return AuthenticationInfo
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;

        String userName = usernamePasswordToken.getUsername();
        String passWord = String.valueOf(usernamePasswordToken.getPassword());

        // 根据用户名查找登录信息
        SysLoginInfo sysLoginInfo = sysLoginInfoService.findByUserName(userName);

        if (ObjectUtils.isBlank(sysLoginInfo)) {
            throw new AccountException("账号或密码不正确");
        }

        // 对比用户的密码和数据库中的密码是否一致
        if (!passWord.equals(sysLoginInfo.getPassWord())) {
            throw new AccountException("账号或密码不正确");
        }

        // 判断账号是否已经被禁用
        if (sysLoginInfo.getStatus().equals("0")) {
            throw new DisabledAccountException("账号已经被禁用");
        }

        return new SimpleAuthenticationInfo(sysLoginInfo, passWord, userName);
    }
}
