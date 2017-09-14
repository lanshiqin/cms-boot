package com.lanshiqin.cmsboot.core.api;

import com.lanshiqin.cmsboot.core.bean.JsonDataBean;
import com.lanshiqin.cmsboot.core.entity.SysDepInfo;
import com.lanshiqin.cmsboot.core.filter.DepInfoFilter;
import com.lanshiqin.cmsboot.core.service.SysDepInfoService;
import com.lanshiqin.cmsboot.core.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 部门维护接口控制器
 */
@Controller
@RequestMapping("core")
public class SysDepApiController extends JsonBaseController {

    @Autowired
    private SysDepInfoService sysDepInfoService;  // 部门信息服务

    /**
     * 部门信息集合接口
     * @param DepInfoFilter 部门查询过滤器
     * @return 部门信息集合
     */
    @RequestMapping(value = "getDepInfoList")
    @ResponseBody
    public JsonDataBean getDepInfoList(DepInfoFilter DepInfoFilter){

        List<SysDepInfo> sysDepInfoList = sysDepInfoService.search(DepInfoFilter);
        if (ObjectUtils.isBlank(sysDepInfoList)){
            return getJsonDataBean("200","部门信息为空");
        }
        return getJsonDataBean("200","部门信息集合",sysDepInfoList);
    }

    /**
     * 保存部门信息
     * @param sysDepInfo 部门信息
     * @return 保存状态
     */
    @RequestMapping(value = "saveDepInfo")
    @ResponseBody
    public JsonDataBean saveDepInfo(SysDepInfo sysDepInfo){
        sysDepInfo.setSysId(null);
        if (sysDepInfoService.insertSelective(sysDepInfo)>0){
            return getJsonDataBean("200","保存成功");
        }
        return getJsonDataBean("500","保存失败");
    }

    /**
     * 删除部门信息
     * @param idList 部门信息id集合
     * @return 删除状态
     */
    @RequestMapping(value = "deleteDepInfo")
    @ResponseBody
    public JsonDataBean deleteDepInfo(@RequestParam("idList") List<String> idList){

        if (sysDepInfoService.deleteIn(idList)>0){
            return getJsonDataBean("200","删除成功");
        }
        return getJsonDataBean("500","删除失败");
    }

    /**
     * 更新部门信息
     * @param sysDepInfo 部门信息
     * @return 更新状态
     */
    @RequestMapping(value = "updateDepInfo")
    @ResponseBody
    public JsonDataBean updateDepInfo(SysDepInfo sysDepInfo){
        if (sysDepInfoService.update(sysDepInfo)>0){
            return getJsonDataBean("200","更新成功");
        }
        return getJsonDataBean("500","更新失败");
    }
}
