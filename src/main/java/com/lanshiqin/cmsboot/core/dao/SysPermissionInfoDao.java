package com.lanshiqin.cmsboot.core.dao;

import com.lanshiqin.cmsboot.core.filter.PermissionInfoFilter;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.lanshiqin.cmsboot.core.entity.SysPermissionInfo;

@Mapper
public interface SysPermissionInfoDao {
    int insert(@Param("pojo") SysPermissionInfo pojo);

    int insertSelective(@Param("pojo") SysPermissionInfo pojo);

    int insertList(@Param("pojos") List<SysPermissionInfo> pojo);

    int update(@Param("pojo") SysPermissionInfo pojo);

    List<SysPermissionInfo> findByIn(@Param("permissionIdList") List<String> permissionIdList);

    List<SysPermissionInfo> search(@Param("permissionInfoFilter") PermissionInfoFilter permissionInfoFilter);

    int deleteIn(@Param("idList") List<String> idList);
}
