package org.example.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.pojo.Article;
import org.example.pojo.Result;
import org.example.service.ArticleService;
import org.example.utils.JwtUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping("add")
    public Result add(@RequestBody @Validated Article article){
        articleService.add(article);
        return Result.success();
    }
}
