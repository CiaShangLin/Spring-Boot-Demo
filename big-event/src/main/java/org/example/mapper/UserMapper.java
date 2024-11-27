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

    @Update("update user set user_pic=#{avatarUrl},update_time=now() where id=#{id}")
    void updateAvatarUrl(String avatarUrl, Integer id);

    @Update("update user set password=#{newPwd},update_time=now() where id=#{id}")
    void updatePwd(String newPwd, Integer id);
}
