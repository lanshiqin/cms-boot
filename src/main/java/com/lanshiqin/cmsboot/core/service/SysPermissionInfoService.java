package com.lanshiqin.cmsboot.core.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.lanshiqin.cmsboot.core.entity.SysPermissionInfo;
import com.lanshiqin.cmsboot.core.dao.SysPermissionInfoDao;

@Service
public class SysPermissionInfoService{

    @Resource
    private SysPermissionInfoDao sysPermissionInfoDao;

    public int insert(SysPermissionInfo pojo){
        return sysPermissionInfoDao.insert(pojo);
    }

    public int insertSelective(SysPermissionInfo pojo){
        return sysPermissionInfoDao.insertSelective(pojo);
    }

    public int insertList(List<SysPermissionInfo> pojos){
        return sysPermissionInfoDao.insertList(pojos);
    }

    public int update(SysPermissionInfo pojo){
        return sysPermissionInfoDao.update(pojo);
    }

    public List<SysPermissionInfo> findByIn(List<String> permissionIdList) {
        return sysPermissionInfoDao.findByIn(permissionIdList);
    }
}
