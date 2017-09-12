package com.lanshiqin.cmsboot.core.api;

import com.lanshiqin.cmsboot.core.bean.JsonDataBean;
import com.lanshiqin.cmsboot.core.entity.SysPermissionInfo;
import com.lanshiqin.cmsboot.core.filter.PermissionInfoFilter;
import com.lanshiqin.cmsboot.core.service.SysPermissionInfoService;
import com.lanshiqin.cmsboot.core.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("core")
public class SysPermissionInfoApiController extends JsonBaseController {

    @Autowired
    private SysPermissionInfoService sysPermissionInfoService;  // 权限信息服务

    /**
     * 权限信息集合接口
     * @param permissionInfoFilter 权限查询过滤器
     * @return 权限信息集合
     */
    @RequestMapping(value = "getPermissionInfoList")
    @ResponseBody
    public JsonDataBean getPermissionInfoList(PermissionInfoFilter permissionInfoFilter){

        List<SysPermissionInfo> sysPermissionInfoList = sysPermissionInfoService.search(permissionInfoFilter);
        if (ObjectUtils.isBlank(sysPermissionInfoList)){
            return getJsonDataBean("200","权限信息为空");
        }
        return getJsonDataBean("200","权限信息集合",sysPermissionInfoList);
    }

    /**
     * 保存权限信息
     * @param sysPermissionInfo 权限信息
     * @return 保存状态
     */
    @RequestMapping(value = "savePermissionInfo")
    @ResponseBody
    public JsonDataBean savePermissionInfo(SysPermissionInfo sysPermissionInfo){
        sysPermissionInfo.setSysId(null);
        if (sysPermissionInfoService.insertSelective(sysPermissionInfo)>0){
            return getJsonDataBean("200","保存成功");
        }
        return getJsonDataBean("500","保存失败");
    }

    /**
     * 删除权限信息
     * @param idList 权限信息id集合
     * @return 删除状态
     */
    @RequestMapping(value = "deletePermissionInfo")
    @ResponseBody
    public JsonDataBean deletePermissionInfo(@RequestParam("idList") List<String> idList){

        if (sysPermissionInfoService.deleteIn(idList)>0){
            return getJsonDataBean("200","删除成功");
        }
        return getJsonDataBean("500","删除失败");
    }

    /**
     * 更新权限信息
     * @param sysPermissionInfo 权限信息
     * @return 更新状态
     */
    @RequestMapping(value = "updatePermissionInfo")
    @ResponseBody
    public JsonDataBean updatePermissionInfo(SysPermissionInfo sysPermissionInfo){
        if (sysPermissionInfoService.update(sysPermissionInfo)>0){
            return getJsonDataBean("200","更新成功");
        }
        return getJsonDataBean("500","更新失败");
    }
}
