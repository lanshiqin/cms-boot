package com.lanshiqin.cmsboot.core.service;

import com.lanshiqin.cmsboot.core.filter.DepInfoFilter;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.lanshiqin.cmsboot.core.entity.SysDepInfo;
import com.lanshiqin.cmsboot.core.dao.SysDepInfoDao;

@Service
public class SysDepInfoService{

    @Resource
    private SysDepInfoDao sysDepInfoDao;

    public int insert(SysDepInfo pojo){
        return sysDepInfoDao.insert(pojo);
    }

    public int insertSelective(SysDepInfo pojo){
        return sysDepInfoDao.insertSelective(pojo);
    }

    public int insertList(List<SysDepInfo> pojos){
        return sysDepInfoDao.insertList(pojos);
    }

    public int update(SysDepInfo pojo){
        return sysDepInfoDao.update(pojo);
    }

    public List<SysDepInfo> search(DepInfoFilter depInfoFilter) {
        return sysDepInfoDao.search(depInfoFilter);
    }

    public int deleteIn(List<String> idList) {
        return sysDepInfoDao.deleteIn(idList);
    }
}
