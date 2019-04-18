package com.yxj.eurekaoauth2.mapper;

import cn.yxj.eurekaapi.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select * from user where user_name =#{username}")
    User loadUserByUsername(String username);
}
