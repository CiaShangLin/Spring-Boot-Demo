package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户管理持久层
 */
@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {
}
