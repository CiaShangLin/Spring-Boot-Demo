package org.example.controller;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/test")
@ConfigurationProperties(prefix = "user")
public class TestController {

    @GetMapping("/hello")
    public String index() {
        return "Hello World!";
    }

    //@Value("${user.nName}")
    private String userName;
    //@Value("${user.sex}")
    private String sex;
    //@Value("${user.age}")
    private Integer age;

    @GetMapping("/hello2")
    public String index2() {
        return "我是" + getUserName() + ",性别：" + getSex() + ",我今年" + getAge() + "岁啦！";
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}



