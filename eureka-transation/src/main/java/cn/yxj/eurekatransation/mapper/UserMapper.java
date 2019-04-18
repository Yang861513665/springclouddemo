package cn.yxj.eurekatransation.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {
    @Update("update user set age=20 where user_name=#{username}")
    int updateUser(@Param(value = "username") String name);
}
