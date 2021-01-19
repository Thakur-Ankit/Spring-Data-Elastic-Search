package com.example.springdataelasticsearch.controller;

import com.example.springdataelasticsearch.model.Article;
import com.example.springdataelasticsearch.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    ElasticsearchRestTemplate elasticsearchTemplate;

    @Autowired
    ArticleService articleService;

    @GetMapping("initializeIndexing")
    public boolean initializeIndexing() {
        return articleService.initializeIndexing();
    }

    @GetMapping("insertData")
    public boolean insertDataInIndex() {
        return articleService.insertDataInIndex();
    }

    @GetMapping("searchQuery")
    public List<Article> searchQuery() {
        return articleService.searchQuery();
    }

    @GetMapping("searchByTitle")
    public Page<Article> findByTitle(@RequestParam("title") String title) {
        return articleService.findByTitle(title);
    }

    @GetMapping("searchByCategory")
    public Page<Article> findByCategoriesContaining(@RequestParam("category") String category) {
        return articleService.findByCategoriesContaining(category);
    }

    @GetMapping("searchByAuthorName")
    public Page<Article> searchByAuthorName(@RequestParam("name") String name) {
        return articleService.findByAuthorsName(name);
    }

    @GetMapping("searchByAuthorAge")
    public Page<Article> searchByAuthorAge(@RequestParam("age") String age) {
        return articleService.findByAuthorsAge(age);
    }

    @GetMapping("searchByCustomQueryAnnotation")
    public Page<Article> findByAuthorsNameUsingCustomQueryAnnotation(@RequestParam("name") String name) {
        return articleService.findByAuthorsNameUsingCustomQueryAnnotation(name);
    }

    @GetMapping("searchOnAllFields")
    public Page<Article> searchOnAllFields(@RequestParam("query") String query) {
        return articleService.searchOnAllFields(query);
    }
}
