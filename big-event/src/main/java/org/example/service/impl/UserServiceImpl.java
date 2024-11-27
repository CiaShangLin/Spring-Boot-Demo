package org.example.service.impl;

import org.example.mapper.UserMapper;
import org.example.pojo.User;
import org.example.service.UserService;
import org.example.utils.MD5Utils;
import org.example.utils.ThreadLocalUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByUserName(String username) {
        User user = userMapper.findByUserName(username);
        return user;
    }

    @Override
    public void register(String username, String password) {
        String md5 = MD5Utils.encrypt(password);
        userMapper.add(username,md5);
    }

    @Override
    public void update(User user) {
        user.setUpdateTime(LocalDateTime.now());
        userMapper.update(user);
    }

    @Override
    public void updateAvatarUrl(String avatarUrl) {
        Map<String,Object> claims = ThreadLocalUnit.get();
        Integer id = (Integer) claims.get("id");
        userMapper.updateAvatarUrl(avatarUrl,id);
    }

    @Override
    public void updatePwd(String newPwd) {
        Map<String,Object> claims = ThreadLocalUnit.get();
        Integer id = (Integer) claims.get("id");
        userMapper.updatePwd(MD5Utils.encrypt(newPwd),id);
    }
}
