package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping( "/hello")
    public String index() {
        return "Hello World!";
    }
    @Value("${user.userName}")
    private String userName;
    @Value("${user.sex}")
    private String sex;
    @Value("${user.age}")
    private Integer age;

    @GetMapping("/hello2")
    public String index2() {
        return "我是"+userName+",性别："+sex+",我今年"+age+"岁啦！";}
}



