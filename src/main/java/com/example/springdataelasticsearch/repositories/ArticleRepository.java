package com.example.springdataelasticsearch.repositories;

import com.example.springdataelasticsearch.model.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ArticleRepository extends ElasticsearchRepository<Article, String> {

    @Query("{ \"match_all\": {}}")
    List<Article> searchQuery();

    Page<Article> findByTitle(String name, Pageable pageable);

    Page<Article> findByCategoriesContaining(String name, Pageable pageable);

    Page<Article> findByAuthorsName(String name, Pageable pageable);

    Page<Article> findByAuthorsAge(int age, Pageable pageable);

    @Query("{\"range\": {\"authors.age\": {\"gte\": \"?0\", \"lte\": \"?1\"}}}")
    Page<Article> findByAuthorsAgeInRange(int minAge, int maxAge, Pageable pageable);

    @Query("{\"multi_match\" : {\"query\": \"?0\", \"fields\": [ \"id\", \"title\", \"publishedDate\", \"description\", \"categories\", \"authors.id\", \"authors.name\", \"authors.age\"]}}")
    Page<Article> searchOnAllFields(String query, Pageable pageable);

}
