package com.example.demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.UserEntity;
import com.example.demo.mapper.UserMapper;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {


    /**
     * 不分页查询所有用户信息
     */
    @Override
    public List<UserEntity> getUsers() {
        //直接可使用IService 封装好的一些方法，这个自行点进去看。
        return this.list();
    }

    /**
     * 根据性别查询所有用户
     *
     * @param sex 性别
     */
    @Override
    public List<UserEntity> getUsersBySex(String sex) {
        //条件构造器
        QueryWrapper<UserEntity> wrapper = new QueryWrapper<>();
        //eq 代表“ = ”；例如 eq("sex", "男") ---> sex = '男';等同于拼接在sql语句后边的where条件。
        wrapper.eq("sex", sex);
        //将条件带入返回
        List<UserEntity> list = this.list(wrapper);
        //返回数据
        return list;
    }
}
