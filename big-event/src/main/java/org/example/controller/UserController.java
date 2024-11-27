package org.example.controller;

import jakarta.validation.constraints.Pattern;
import org.example.pojo.Result;
import org.example.pojo.User;
import org.example.service.UserService;
import org.example.utils.JwtUnit;
import org.example.utils.MD5Utils;
import org.example.utils.ThreadLocalUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController()
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

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
            String token = JwtUnit.getToken(claims);
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
}
