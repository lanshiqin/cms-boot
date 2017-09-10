package com.lanshiqin.cmsboot.core.api;

import com.lanshiqin.cmsboot.core.bean.JsonDataBean;
import com.lanshiqin.cmsboot.core.entity.SysRoleInfo;
import com.lanshiqin.cmsboot.core.filter.RoleInfoFilter;
import com.lanshiqin.cmsboot.core.service.SysRoleInfoService;
import com.lanshiqin.cmsboot.core.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 角色信息接口控制器
 */
@Controller
@RequestMapping("core")
public class SysRoleInfoApiController extends JsonBaseController {

    @Autowired
    private SysRoleInfoService sysRoleInfoService;  // 角色信息服务

    /**
     * 获取角色信息列表
     * @param roleInfoFilter 角色信息查询过滤器
     * @return 角色信息列表
     */
    @RequestMapping(value = "getRoleInfoList")
    @ResponseBody
    public JsonDataBean getRoleInfoList(RoleInfoFilter roleInfoFilter){

        List<SysRoleInfo> sysRoleInfoList = sysRoleInfoService.search(roleInfoFilter);
        if (ObjectUtils.isBlank(sysRoleInfoList)){
            return getJsonDataBean("200","角色信息为空");
        }
        return getJsonDataBean("200","角色信息列表",sysRoleInfoList);
    }

    /**
     * 保存角色信息
     * @param sysRoleInfo 角色信息
     * @return 保存状态
     */
    @RequestMapping(value = "saveRoleInfo")
    @ResponseBody
    public JsonDataBean saveRoleInfo(SysRoleInfo sysRoleInfo){

        if (ObjectUtils.isBlank(sysRoleInfo.getName())){
            return getJsonDataBean("500","角色名字不能为空");
        }
        if (ObjectUtils.isBlank(sysRoleInfo.getType())){
            return getJsonDataBean("500","角色类别不能为空");
        }
        sysRoleInfo.setSysId(null);
        if (sysRoleInfoService.insertSelective(sysRoleInfo)>0){

            return getJsonDataBean("200","保存成功");
        }
        return getJsonDataBean("500","保存失败");
    }

    /**
     * 删除角色信息
     * @param idList 角色信息id集合
     * @return 删除状态
     */
    @RequestMapping(value = "deleteRoleInfo")
    @ResponseBody
    public JsonDataBean deleteRoleInfo(@RequestParam("idList") List<String> idList){

        if (sysRoleInfoService.deleteIn(idList)>0){

            return getJsonDataBean("200","删除成功");
        }
        return getJsonDataBean("500","删除失败");
    }

    /**
     * 更新角色信息
     * @param sysRoleInfo 角色信息
     * @return 更新状态
     */
    @RequestMapping(value = "updateRoleInfo")
    @ResponseBody
    public JsonDataBean updateRoleInfo(SysRoleInfo sysRoleInfo){

        if (ObjectUtils.isBlank(sysRoleInfo.getSysId())){
            return getJsonDataBean("500","id不能为空");
        }
        if (sysRoleInfoService.update(sysRoleInfo)>0){

            return getJsonDataBean("200","更新成功");
        }
        return getJsonDataBean("500","更新失败");
    }


}
