package org.example.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.pojo.Result;
import org.example.utils.JwtUnit;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @GetMapping("/list")
    public Result<String> list(
//            @RequestHeader(name = "Authorization") String token, HttpServletResponse response
    ) {
//        try {
//            Map<String , Object> claims = JwtUnit.parseToken(token);
//
//        }catch (Exception e){
//            response.setStatus(401);
//            return Result.error("未登入");
//        }
        return Result.success("All...");
    }
}
