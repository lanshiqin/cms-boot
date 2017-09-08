package com.lanshiqin.cmsboot.core.api;

import com.lanshiqin.cmsboot.core.bean.JsonDataBean;
import com.lanshiqin.cmsboot.core.bean.UserInfoBean;
import com.lanshiqin.cmsboot.core.entity.SysLoginInfo;
import com.lanshiqin.cmsboot.core.entity.SysUserInfo;
import com.lanshiqin.cmsboot.core.filter.UserInfoFilter;
import com.lanshiqin.cmsboot.core.service.SysLoginInfoService;
import com.lanshiqin.cmsboot.core.service.SysUserInfoService;
import com.lanshiqin.cmsboot.core.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户信息接口控制器
 */
@Controller
@RequestMapping("core")
public class SysUserInfoApiController extends JsonBaseController {

    @Autowired
    private SysUserInfoService sysUserInfoService;      // 用户信息服务

    @Autowired
    private SysLoginInfoService sysLoginInfoService;    // 登录信息服务

    /**
     * 获取用户信息列表
     * @return 用户信息列表
     */
    @RequestMapping("/getUserInfoList")
    @ResponseBody
    public JsonDataBean getUserInfoList(UserInfoFilter userInfoFilter){

        List<SysUserInfo> sysUserInfoList = sysUserInfoService.search(userInfoFilter);

        if (ObjectUtils.isBlank(sysUserInfoList)){
            return getJsonDataBean("200","用户信息为空");
        }

        List<UserInfoBean> userInfoBeanList = new ArrayList<>();
        for (SysUserInfo sysUserInfo: sysUserInfoList){
            UserInfoBean userInfoBean = new UserInfoBean();
            userInfoBean.setSysId(sysUserInfo.getSysId());
            userInfoBean.setNick(sysUserInfo.getNick());
            userInfoBean.setSex(sysUserInfo.getSex());
            userInfoBean.setBirthday(sysUserInfo.getBirthday());
            userInfoBeanList.add(userInfoBean);
        }

        return getJsonDataBean("200","用户信息",userInfoBeanList);
    }

    /**
     * 保存用户信息
     * @param userInfoFilter 用户信息过滤器
     * @return 保存状态
     */
    @RequestMapping("/saveUserInfo")
    @ResponseBody
    @Transactional
    public JsonDataBean saveUserInfo(UserInfoFilter userInfoFilter){

        SysUserInfo sysUserInfo = new SysUserInfo();
        sysUserInfo.setNick(userInfoFilter.getNick());
        sysUserInfo.setSex(userInfoFilter.getSex());
        sysUserInfo.setBirthday(userInfoFilter.getBirthday());

        if (sysUserInfoService.insertSelective(sysUserInfo)>0){
            SysLoginInfo sysLoginInfo = new SysLoginInfo();
            sysLoginInfo.setUserName(userInfoFilter.getUserName());
            sysLoginInfo.setPassWord(userInfoFilter.getPassWord());
            sysLoginInfo.setUserId(sysUserInfo.getSysId());
            sysLoginInfo.setStatus("1");
            if (sysLoginInfoService.insertSelective(sysLoginInfo)>0){
                return getJsonDataBean("200","保存成功");
            }
        }

        return getJsonDataBean("500","保存失败");
    }


    /**
     * 删除用户信息
     * @param idList 要删除的用户id集合
     * @return 删除状态
     */
    @RequestMapping("/deleteUserInfo")
    @ResponseBody
    @Transactional
    public JsonDataBean deleteUserInfo(@RequestParam("idList") List<String> idList){

        if (sysUserInfoService.delete(idList)>0){

            if (sysLoginInfoService.deleteByUserId(idList)>0){
                return getJsonDataBean("200","删除成功");
            }

        }
        return getJsonDataBean("500","删除失败");
    }
}
