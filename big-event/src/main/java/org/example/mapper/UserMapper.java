package org.example.mapper;

import org.apache.ibatis.annotations.*;
import org.example.pojo.User;

@Mapper
public interface UserMapper {

    @Select("select * from user where username = #{username}")
    User findByUserName(String username);

    @Insert("insert into user(username, password, create_time, update_time) " +
            "values(#{username}, #{password} , now(), now())")
    void add(@Param("username") String username, @Param("password") String md5);

    @Update("update user set nickname=#{nickname},email=#{email},update_time=#{updateTime} where id=#{id}")
    void update(User user);
}
