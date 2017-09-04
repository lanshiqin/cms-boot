package com.lanshiqin.cmsboot.core.service;

import com.lanshiqin.cmsboot.core.filter.UserLoginFilter;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.lanshiqin.cmsboot.core.entity.SysLoginInfo;
import com.lanshiqin.cmsboot.core.dao.SysLoginInfoDao;

@Service
public class SysLoginInfoService{

    @Resource
    private SysLoginInfoDao sysLoginInfoDao;

    public int insert(SysLoginInfo pojo){
        return sysLoginInfoDao.insert(pojo);
    }

    public int insertSelective(SysLoginInfo pojo){
        return sysLoginInfoDao.insertSelective(pojo);
    }

    public int insertList(List<SysLoginInfo> pojos){
        return sysLoginInfoDao.insertList(pojos);
    }

    public int update(SysLoginInfo pojo){
        return sysLoginInfoDao.update(pojo);
    }

    public SysLoginInfo findByUserName(String userName) {
        return sysLoginInfoDao.findByUserName(userName);
    }
}
