package com.lanshiqin.cmsboot.core.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.lanshiqin.cmsboot.core.entity.SysLoginInfo;

@Mapper
public interface SysLoginInfoDao {
    int insert(@Param("pojo") SysLoginInfo pojo);

    int insertSelective(@Param("pojo") SysLoginInfo pojo);

    int insertList(@Param("pojos") List<SysLoginInfo> pojo);

    int update(@Param("pojo") SysLoginInfo pojo);

    SysLoginInfo findByUserName(@Param("userName") String userName);

    int deleteByUserId(@Param("idList") List<String> idList);

    SysLoginInfo findByUserId(@Param("userId") Long userId);
}
