package com.blog.dao;

import com.blog.entity.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer rid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer rid);
    
    User selectByUsername(String username);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}