package org.example.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.pojo.Article;
import org.example.pojo.PageBean;
import org.example.pojo.Result;
import org.example.service.ArticleService;
import org.example.utils.JwtUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/article")
//@CrossOrigin(origins =  "*")//支援跨域
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping("add")
    public Result add(@RequestBody @Validated Article article) {
        articleService.add(article);
        return Result.success();
    }

    @GetMapping("list")
    public Result<PageBean<Article>> list(
            Integer pageNum,
            Integer pageSize,
            @RequestParam(required = false) Integer categoryId,
            @RequestParam(required = false) String state
    ) {
        PageBean<Article> pb = articleService.list(pageNum, pageSize, categoryId, state);
        return Result.success(pb);
    }

    @GetMapping("search")
    public Result<List<Article>> search(
            Integer categoryId,
            String state
    ) {
        List<Article> articles = List.of(
                new Article(1, "Title1", "Content1", "http://example.com/img1", "已發布", 1, 1, LocalDateTime.now(), LocalDateTime.now()),
                new Article(1, "Title2", "Content2", "http://example.com/img2", "草稿", 1, 2, LocalDateTime.now(), LocalDateTime.now()),
                new Article(2, "Title3", "Content3", "http://example.com/img3", "已發布", 2, 3, LocalDateTime.now(), LocalDateTime.now()),
                new Article(2, "Title4", "Content4", "http://example.com/img4", "草稿", 2, 4, LocalDateTime.now(), LocalDateTime.now())
        );

        // 使用 Stream 過濾條件
        List<Article> filteredArticles = articles.stream()
                .filter(article -> article.getCategoryId().equals(categoryId))
                .filter(article -> article.getState().equalsIgnoreCase(state))
                .toList();
        // 返回結果
        return Result.success(filteredArticles);
    }
}
