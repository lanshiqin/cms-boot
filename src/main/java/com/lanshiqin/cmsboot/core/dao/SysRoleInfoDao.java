package com.lanshiqin.cmsboot.core.dao;

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
}
