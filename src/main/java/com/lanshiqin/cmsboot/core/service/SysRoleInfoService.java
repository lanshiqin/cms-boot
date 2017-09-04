package com.lanshiqin.cmsboot.core.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.lanshiqin.cmsboot.core.entity.SysRoleInfo;
import com.lanshiqin.cmsboot.core.dao.SysRoleInfoDao;

@Service
public class SysRoleInfoService{

    @Resource
    private SysRoleInfoDao sysRoleInfoDao;

    public int insert(SysRoleInfo pojo){
        return sysRoleInfoDao.insert(pojo);
    }

    public int insertSelective(SysRoleInfo pojo){
        return sysRoleInfoDao.insertSelective(pojo);
    }

    public int insertList(List<SysRoleInfo> pojos){
        return sysRoleInfoDao.insertList(pojos);
    }

    public int update(SysRoleInfo pojo){
        return sysRoleInfoDao.update(pojo);
    }

    public List<SysRoleInfo> findByIn(List<String> roleIdList) {
        return sysRoleInfoDao.findByIn(roleIdList);
    }
}
