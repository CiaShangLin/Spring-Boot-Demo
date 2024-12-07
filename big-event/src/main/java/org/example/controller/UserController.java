package org.example.controller;

import jakarta.validation.constraints.Pattern;
import org.example.pojo.Result;
import org.example.pojo.User;
import org.example.service.UserService;
import org.example.utils.JwtUnit;
import org.example.utils.MD5Utils;
import org.example.utils.ThreadLocalUnit;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController()
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @PostMapping("register")
    public Result register(@Pattern(regexp = "^\\S{5,16}$") String username, @Pattern(regexp = "^\\S{5,16}$") String password) {
        User user = userService.findByUserName(username);
        if (user == null) {
            userService.register(username, password);
            return Result.success();
        } else {
            return Result.error("用戶名已被占用");
        }
    }

    @PostMapping("/login")
    public Result<String> login(@Pattern(regexp = "^\\S{5,16}$") String username, @Pattern(regexp = "^\\S{5,16}$") String password) {
        User user = userService.findByUserName(username);
        if(user == null){
            return Result.error("沒有用戶名");
        }
        if(MD5Utils.encrypt(password).equals(user.getPassword())){
            Map<String, Object> claims = new HashMap<>();
            claims.put("username", username);
            claims.put("password", password);
            claims.put("id", user.getId());
            String token = JwtUnit.getToken(claims);

            ValueOperations<String,String> valueOperations =  stringRedisTemplate.opsForValue();
            valueOperations.set("token",token,1, TimeUnit.HOURS);
            return Result.success(token);
        }
        return Result.error("密碼錯誤");
    }

    @GetMapping("userinfo")
    public Result<User> getUserInfo(@RequestHeader(name = "Authorization") String token){
       Map<String,Object> claims = ThreadLocalUnit.get();
       String username = (String) claims.get("username");
       User user = userService.findByUserName(username);
       return Result.success(user);
    }

    @PutMapping("update")
    public Result<User> update(@RequestBody @Validated User user){
        userService.update(user);
        return Result.success();
    }

    @PatchMapping("updateAvatar")
    public Result<User> updateAvatarUrl(@RequestParam @URL String avatarUrl){
        userService.updateAvatarUrl(avatarUrl);
        return Result.success();
    }

    @PatchMapping("updatePwd")
    public Result<User> updatePwd(@RequestBody Map<String,String> params){
        String oldPwd = params.get("old_pwd");
        String newPwd = params.get("new_pwd");
        String rePwd = params.get("re_pwd");
        if(!StringUtils.hasLength(oldPwd) || !StringUtils.hasLength(newPwd) || !StringUtils.hasLength(rePwd)){
            return Result.error("缺少必要參數");
        }
        Map<String,Object> claims = ThreadLocalUnit.get();
        String username = (String) claims.get("username");
        User user = userService.findByUserName(username);
        if(!MD5Utils.encrypt(oldPwd).equals(user.getPassword())){
            return Result.error("原密碼條寫不正確");
        }
        if (!newPwd.equals(rePwd)){
            return Result.error("兩次填寫密碼不同");
        }
        userService.updatePwd(newPwd);

        ValueOperations<String,String> valueOperations =  stringRedisTemplate.opsForValue();
        valueOperations.getOperations().delete("token");
        return Result.success();
    }
}
