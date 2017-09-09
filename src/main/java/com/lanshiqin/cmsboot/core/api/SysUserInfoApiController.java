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

            SysLoginInfo sysLoginInfo = sysLoginInfoService.findByUserId(sysUserInfo.getSysId());

            UserInfoBean userInfoBean = new UserInfoBean();
            userInfoBean.setSysId(sysUserInfo.getSysId());
            userInfoBean.setNick(sysUserInfo.getNick());
            userInfoBean.setSex(sysUserInfo.getSex());
            userInfoBean.setBirthday(sysUserInfo.getBirthday());

            if (ObjectUtils.isNotBlank(sysLoginInfo)){
                userInfoBean.setUserName(sysLoginInfo.getUserName());
                userInfoBean.setPassWord(sysLoginInfo.getPassWord());
                if(sysLoginInfo.getStatus().equals("1")){
                    userInfoBean.setStatus("正常");
                }else if(sysLoginInfo.getStatus().equals("0")){
                    userInfoBean.setStatus("禁用");
                }
            }

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

        // 校验必填参数
        if (ObjectUtils.isBlank(userInfoFilter.getUserName())){
            return getJsonDataBean("500","用户名不能为空");
        }
        if (ObjectUtils.isBlank(userInfoFilter.getPassWord())){
            return getJsonDataBean("500","密码不能为空");
        }
        if (ObjectUtils.isBlank(userInfoFilter.getNick())){
            return getJsonDataBean("500","昵称不能为空");
        }

        // 校验用户名是否已经存在
        SysLoginInfo sysLoginInfo =  sysLoginInfoService.findByUserName(userInfoFilter.getUserName());

        if (ObjectUtils.isNotBlank(sysLoginInfo)){
            return getJsonDataBean("500","用户名已存在,请重新输入");
        }

        SysUserInfo sysUserInfo = new SysUserInfo();
        sysUserInfo.setNick(userInfoFilter.getNick());
        sysUserInfo.setSex(userInfoFilter.getSex());
        sysUserInfo.setBirthday(userInfoFilter.getBirthday());

        if (sysUserInfoService.insertSelective(sysUserInfo)>0){
            sysLoginInfo = new SysLoginInfo();
            sysLoginInfo.setUserName(userInfoFilter.getUserName());
            sysLoginInfo.setPassWord(userInfoFilter.getPassWord());
            sysLoginInfo.setUserId(sysUserInfo.getSysId());

            if (ObjectUtils.isBlank(userInfoFilter.getStatus())){   // 如果账户状态没有值，默认设置为启用
                sysLoginInfo.setStatus("1");
            }else{
                sysLoginInfo.setStatus(userInfoFilter.getStatus());
            }
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

    /**
     * 更新用户信息
     * @param userInfoFilter 用户信息过滤器
     * @return 更新状态
     */
    @RequestMapping("/editUserInfo")
    @ResponseBody
    @Transactional
    public JsonDataBean editUserInfo(UserInfoFilter userInfoFilter){

        if (ObjectUtils.isBlank(userInfoFilter.getSysId())){
            return getJsonDataBean("500","更新失败","用户id不能为空");
        }

        SysUserInfo sysUserInfo = sysUserInfoService.findById(Long.valueOf(userInfoFilter.getSysId()));

        if (ObjectUtils.isBlank(sysUserInfo)){
            return getJsonDataBean("500","更新失败","用户不存在");
        }

        sysUserInfo.setNick(userInfoFilter.getNick());
        sysUserInfo.setSex(userInfoFilter.getSex());
        sysUserInfo.setBirthday(userInfoFilter.getBirthday());

        if (sysUserInfoService.update(sysUserInfo)>0){

            SysLoginInfo sysLoginInfo = sysLoginInfoService.findByUserId(sysUserInfo.getSysId());

            if (ObjectUtils.isBlank(sysLoginInfo)){
                return getJsonDataBean("500","更新失败","用户登录信息不存在");
            }

            sysLoginInfo.setUserName(userInfoFilter.getUserName());
            sysLoginInfo.setPassWord(userInfoFilter.getPassWord());
            sysLoginInfo.setStatus(userInfoFilter.getStatus());
            if (sysLoginInfoService.update(sysLoginInfo)>0){
                return getJsonDataBean("200","编辑成功");
            }
        }

        return getJsonDataBean("500","更新失败");
    }
}
