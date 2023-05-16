package com.itwst.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itwst.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * name:Mir_Wang
 * Auther:1063383540@qq.com
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Select("select * from user where username=#{username} and password=#{userpwd}")
    User selByUser(@Param("username") String username, @Param("userpwd") String userpwd);

    @Select("select * from user where username=#{username}")
    User selByUserName(String username);
}
