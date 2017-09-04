package com.lanshiqin.cmsboot.core.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.lanshiqin.cmsboot.core.entity.SysRolePermission;

@Mapper
public interface SysRolePermissionDao {
    int insert(@Param("pojo") SysRolePermission pojo);

    int insertSelective(@Param("pojo") SysRolePermission pojo);

    int insertList(@Param("pojos") List<SysRolePermission> pojo);

    int update(@Param("pojo") SysRolePermission pojo);

    List<SysRolePermission> findByIn(@Param("roleIdList") List<String> roleIdList);
}
