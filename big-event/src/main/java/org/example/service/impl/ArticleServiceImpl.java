package org.example.service.impl;

import org.example.mapper.ArticleMapper;
import org.example.pojo.Article;
import org.example.service.ArticleService;
import org.example.utils.ThreadLocalUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public void add(Article article) {
        article.setCreateTime(LocalDateTime.now());
        article.setUpdateTime(LocalDateTime.now());
        Map<String, Object> claims = ThreadLocalUnit.get();
        Integer id = (Integer) claims.get("id");
        article.setCreateUser(id);
        articleMapper.add(article);
    }
}
