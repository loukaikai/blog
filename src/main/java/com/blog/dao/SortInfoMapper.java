package com.blog.dao;

import java.util.List;

import com.blog.entity.SortInfo;

public interface SortInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SortInfo record);

    int insertSelective(SortInfo record);

    SortInfo selectByPrimaryKey(Long id);
    
    SortInfo selectByname(String name);

    int updateByPrimaryKeySelective(SortInfo record);

    int updateByPrimaryKey(SortInfo record);
   
    List<SortInfo> selectAllSort();
    
}