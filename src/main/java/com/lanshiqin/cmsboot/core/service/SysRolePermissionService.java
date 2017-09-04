package com.lanshiqin.cmsboot.core.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.lanshiqin.cmsboot.core.entity.SysRolePermission;
import com.lanshiqin.cmsboot.core.dao.SysRolePermissionDao;

@Service
public class SysRolePermissionService{

    @Resource
    private SysRolePermissionDao sysRolePermissionDao;

    public int insert(SysRolePermission pojo){
        return sysRolePermissionDao.insert(pojo);
    }

    public int insertSelective(SysRolePermission pojo){
        return sysRolePermissionDao.insertSelective(pojo);
    }

    public int insertList(List<SysRolePermission> pojos){
        return sysRolePermissionDao.insertList(pojos);
    }

    public int update(SysRolePermission pojo){
        return sysRolePermissionDao.update(pojo);
    }

    public List<SysRolePermission> findByIn(List<String> roleIdList) {
        return sysRolePermissionDao.findByIn(roleIdList);
    }
}
