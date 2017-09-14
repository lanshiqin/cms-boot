package com.lanshiqin.cmsboot.core.dao;

import com.lanshiqin.cmsboot.core.filter.DepInfoFilter;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.lanshiqin.cmsboot.core.entity.SysDepInfo;

@Mapper
public interface SysDepInfoDao {
    int insert(@Param("pojo") SysDepInfo pojo);

    int insertSelective(@Param("pojo") SysDepInfo pojo);

    int insertList(@Param("pojos") List<SysDepInfo> pojo);

    int update(@Param("pojo") SysDepInfo pojo);

    List<SysDepInfo> search(@Param("depInfoFilter") DepInfoFilter depInfoFilter);

    int deleteIn(@Param("idList") List<String> idList);
}
