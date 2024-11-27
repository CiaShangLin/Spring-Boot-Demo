package org.example.service;

import org.example.pojo.User;
import org.hibernate.validator.constraints.URL;

public interface  UserService {
    public User findByUserName(String username);

    public void register(String username, String password) ;

    public void update(User user);

    public void updateAvatarUrl(String avatarUrl);

    public void updatePwd(String newPwd);
}
