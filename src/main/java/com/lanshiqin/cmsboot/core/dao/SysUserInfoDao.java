package com.lanshiqin.cmsboot.core.dao;

import com.lanshiqin.cmsboot.core.filter.UserInfoFilter;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.lanshiqin.cmsboot.core.entity.SysUserInfo;

@Mapper
public interface SysUserInfoDao {
    int insert(@Param("pojo") SysUserInfo pojo);

    int insertSelective(@Param("pojo") SysUserInfo pojo);

    int insertList(@Param("pojos") List<SysUserInfo> pojo);

    int update(@Param("pojo") SysUserInfo pojo);

    SysUserInfo findById(@Param("userId") Long userId);

    List<SysUserInfo> search(@Param("pojo") UserInfoFilter userInfoFilter);

    int delete(@Param("idList") List<String> idList);
}
