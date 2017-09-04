package com.lanshiqin.cmsboot.core.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.lanshiqin.cmsboot.core.entity.SysUserInfo;
import com.lanshiqin.cmsboot.core.dao.SysUserInfoDao;

@Service
public class SysUserInfoService{

    @Resource
    private SysUserInfoDao sysUserInfoDao;

    public int insert(SysUserInfo pojo){
        return sysUserInfoDao.insert(pojo);
    }

    public int insertSelective(SysUserInfo pojo){
        return sysUserInfoDao.insertSelective(pojo);
    }

    public int insertList(List<SysUserInfo> pojos){
        return sysUserInfoDao.insertList(pojos);
    }

    public int update(SysUserInfo pojo){
        return sysUserInfoDao.update(pojo);
    }

    public SysUserInfo findById(Long userId) {
        return sysUserInfoDao.findById(userId);
    }
}
