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

    @GetMapping("searchById")
    public Page<Article> findById(@RequestParam("id") int id) {
        return articleService.findById(id);
    }

    @GetMapping("searchByTitle")
    public Page<Article> findByTitle(@RequestParam("title") String title) {
        return articleService.findByTitle(title);
    }

    @GetMapping("searchByCategory")
    public Page<Article> findByCategoriesContaining(@RequestParam("category") String category) {
        return articleService.findByCategoriesContaining(category);
    }

    /*@GetMapping("searchByPublishedDate")
    public Page<Article> searchByPublishedDate(@RequestParam("date") Date date) {
        return articleService.findByPublishedDate(date);
    }*/

    @GetMapping("searchByAuthorId")
    public Page<Article> searchByAuthorId(@RequestParam("id") int id) {
        return articleService.findByAuthorsId(id);
    }

    @GetMapping("searchByAuthorName")
    public Page<Article> searchByAuthorName(@RequestParam("name") String name) {
        return articleService.findByAuthorsName(name);
    }

    @GetMapping("searchByAuthorAge")
    public Page<Article> searchByAuthorAge(@RequestParam("age") int age) {
        return articleService.findByAuthorsAge(age);
    }

    @GetMapping("searchByAuthorAgeInRange")
    public Page<Article> searchByAuthorAgeInRange(@RequestParam("minAge") int minAge, @RequestParam("maxAge") int maxAge) {
        return articleService.findByAuthorsAgeInRange(minAge, maxAge);
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
