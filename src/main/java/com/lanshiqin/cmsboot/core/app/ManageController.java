package com.lanshiqin.cmsboot.core.app;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 管理面板控制器
 */
@Controller
@RequestMapping("core")
public class ManageController {

    /**
     * 跳转到管理页面
     * @return 管理页面模板视图
     */
    @RequestMapping("/manage")
    @RequiresPermissions("core:manage:layout")
    public String toManage(){
        return "core_manage_menu";
    }

    /**
     * 跳转到系统信息维护页面
     * @return 系统信息页面模板视图
     */
    @RequestMapping("/sysinfo")
    @RequiresPermissions("core:sysinfo:layout")
    public String toSysInfoLayout(){
        return "core_sysinfo_layout";
    }

    /**
     * 跳转到用户信息维护页面
     * @return 用户信息页面模板视图
     */
    @RequestMapping("/userinfo")
    @RequiresPermissions("core:userinfo:layout")
    public String toUserInfoLayout(){
        return "core_userinfo_layout";
    }

    /**
     * 跳转到角色信息维护页面
     * @return 角色信息页面模板视图
     */
    @RequestMapping("/roleinfo")
    @RequiresPermissions("core:roleinfo:layout")
    public String toRoleInfoLayout(){
        return "core_roleinfo_layout";
    }

    /**
     * 跳转到权限信息维护页面
     * @return 权限信息页面模板视图
     */
    @RequestMapping("/perinfo")
    @RequiresPermissions("core:perinfo:layout")
    public String toPermissionInfoLayout(){
        return "core_perinfo_layout";
    }

    /**
     * 跳转到部门信息维护页面
     * @return 部门信息页面模板视图
     */
    @RequestMapping("/depinfo")
    @RequiresPermissions("core:depinfo:layout")
    public String toDepInfoLayout(){
        return "core_depinfo_layout";
    }

    /**
     * 跳转到没有权限提示信息页面
     * @return 提示信息页面模板视图
     */
    @RequestMapping("/noper")
    public String toNoPermission(){
        return "core_noper_layout";
    }
}
