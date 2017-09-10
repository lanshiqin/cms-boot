package com.lanshiqin.cmsboot.core.dao;

import com.lanshiqin.cmsboot.core.filter.RoleInfoFilter;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.lanshiqin.cmsboot.core.entity.SysRoleInfo;

@Mapper
public interface SysRoleInfoDao {
    int insert(@Param("pojo") SysRoleInfo pojo);

    int insertSelective(@Param("pojo") SysRoleInfo pojo);

    int insertList(@Param("pojos") List<SysRoleInfo> pojo);

    int update(@Param("pojo") SysRoleInfo pojo);

    List<SysRoleInfo> findByIn(@Param("roleIdList") List<String> roleIdList);

    List<SysRoleInfo> search(@Param("roleInfoFilter") RoleInfoFilter roleInfoFilter);

    int deleteIn(@Param("idList") List<String> idList);
}
