package org.example.service;

import org.example.pojo.User;

public interface  UserService {
    public User findByUserName(String username);

    public void register(String username, String password) ;
}
