package com.example.springdataelasticsearch.services;

import com.example.springdataelasticsearch.model.Article;
import com.example.springdataelasticsearch.model.Author;
import com.example.springdataelasticsearch.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.Arrays.asList;

@Service
public class ArticleService {

    @Autowired
    ElasticsearchRestTemplate elasticsearchTemplate;

    @Autowired
    ArticleRepository articleRepository;


    public boolean initializeIndexing() {

        return elasticsearchTemplate.indexOps(Article.class).create();
    }

    public boolean insertDataInIndex() {
        List<Article> articleList = new ArrayList<>();

        Article article1 = new Article();
        article1.setId("1933988673");
        article1.setTitle("Unlocking Android");
        article1.setDescription("Unlocking Android: A Developer's Guide provides concise, hands-on instruction for the Android operating system and development tools. This book teaches important architectural concepts in a straightforward writing style and builds on this with practical and useful examples throughout.");
        article1.setPublishedDate("01-04-2009");
        article1.setCategories(asList("Open Source", "Mobile"));

        Author author1 = new Author();
        author1.setId("101");
        author1.setName("Robi Sen");
        author1.setAge("28");

        Author author2 = new Author();
        author2.setId("102");
        author2.setName("Charlie Collins");
        author2.setAge("32");

        article1.setAuthors(asList(author1, author2));

        Article article2 = new Article();
        article2.setId("1935182927");
        article2.setTitle("Android in Practice");
        article2.setDescription("Android in Practice is treasure trove of Android goodness, with over 100 tested, ready-to-use techniques including complete end-to-end example applications and practical tips for real world mobile application developers. Written by real world Android developers, this book addresses the trickiest questions raised in forums and mailing lists. Using an easy-to-follow problem/solution/discussion format, it dives into important topics not covered in other Android books, like advanced drawing and graphics, testing and instrumentation, building and deploying applications, using alternative languages, and native development.");
        article2.setPublishedDate("30-09-2011");
        article2.setCategories(asList("Mobile"));

        Author author3 = new Author();
        author3.setId("103");
        author3.setName("Charlie Collins");
        author3.setAge("28");

        article2.setAuthors(asList(author3));

        Article article3 = new Article();
        article3.setId("193239415");
        article3.setTitle("Hibernate in Action");
        article3.setDescription("Hibernate practically exploded on the Java scene. Why is this open-source tool so popular  Because it automates a tedious task: persisting your Java objects to a relational database. The inevitable mismatch between your object-oriented code and the relational database requires you to write code that maps one to the other. This code is often complex, tedious and costly to develop. Hibernate does the mapping for you.    Not only that, Hibernate makes it easy. Positioned as a layer between your application and your database, Hibernate takes care of loading and saving of objects. Hibernate applications are cheaper, more portable, and more resilient to change. And they perform better than anything you are likely to develop yourself.    Hibernate in Action carefully explains the concepts you need, then gets you going. It builds on a single example to show you how to use Hibernate in practice, how to deal with concurrency and transactions, how to efficiently retrieve objects and use caching.    The authors created Hibernate and they field questions from the Hibernate community every day - they know how to make Hibernate sing. Knowledge and insight seep out of every pore of this book.");
        article3.setPublishedDate("01-08-2004");
        article3.setCategories(asList("Java"));

        Author author4 = new Author();
        author4.setId("104");
        author4.setName("Gavin King");
        author4.setAge("33");

        Author author5 = new Author();
        author5.setId("105");
        author5.setName("Christian Bauer");
        author5.setAge("34");

        article3.setAuthors(asList(author4, author5));

        Article article4 = new Article();
        article4.setId("1933988177");
        article4.setTitle("Lucene in Action");
        article4.setDescription("With clear writing, reusable examples, and unmatched advice on best practices, Lucene in Action is still the definitive guide to developing with Lucene.");
        article4.setPublishedDate("09-07-2010");
        article4.setCategories(asList("Java", "Open Source"));

        Author author6 = new Author();
        author6.setId("106");
        author6.setName("Erik Hatcher");
        author6.setAge("30");

        Author author7 = new Author();
        author7.setId("107");
        author7.setName("Michael McCandless");
        author7.setAge("32");

        article4.setAuthors(asList(author6, author7));

        Article article5 = new Article();
        article5.setId("1884777716");
        article5.setTitle("Server-Based Java Programming");
        article5.setDescription("Java on the server is here to stay. Whether you're using J2EE or writing your own, you will need to understand the fundamental concepts of server-based Java. Server-Based Java Programming teaches those concepts of Java that underlie the J2EE APIs and the best ways to use them. An ongoing focus on the full lifecycle, including administration and deployment, makes this book a rare, practical guide. One of its themes is the theoretical \"three-zeroes\" goal for server development--zero development, zero administration, and zero deployment.    Server-Based Java Programming isn't just about implementation--it's also about architecture, and design. You'll learn how to write the code that sustains a cutting-edge enterprise. You will learn nuts-and-bolts topics like ClassLoaders, threads, CORBA, RMI/IIOP, and JNI, as well as how to make each of these contribute to enterprise-wide goals such as fault-tolerance, easier system administration, five-nine availability, deployment without headaches, and lower development costs.");
        article5.setPublishedDate("01-06-2000");
        article5.setCategories(asList("Java", "Client-Server", "Internet"));

        Author author8 = new Author();
        author8.setId("108");
        author8.setName("Ted Neward");
        author8.setAge("35");

        article5.setAuthors(asList(author8));

        Article article6 = new Article();
        article6.setId("1930110464");
        article6.setTitle("Instant Messaging in Java");
        article6.setDescription("This intermediate Java programming book provides Java programmers with the information and tools needed to create your own IM client and server software.");
        article6.setPublishedDate("01-03-2002");
        article6.setCategories(asList("Java", "Internet"));

        Author author9 = new Author();
        author9.setId("109");
        author9.setName("Iain Shigeoka");
        author9.setAge("31");

        article6.setAuthors(asList(author9));

        articleList.add(article1);
        articleList.add(article2);
        articleList.add(article3);
        articleList.add(article4);
        articleList.add(article5);
        articleList.add(article6);

        return Objects.nonNull(articleRepository.saveAll(articleList));
    }

    public List<Article> searchQuery() {
        return articleRepository.searchQuery();
    }

    public Page<Article> findByAuthorsName(String name) {
        return articleRepository.findByAuthorsName(name, PageRequest.of(0, 10));
    }

    public Page<Article> findByAuthorsAge(String age) {
        return articleRepository.findByAuthorsAge(age, PageRequest.of(0, 10));
    }

    public Page<Article> findByTitle(String title) {
        return articleRepository.findByTitle(title, PageRequest.of(0, 10));
    }

    public Page<Article> findByCategoriesContaining(String category) {
        return articleRepository.findByCategoriesContaining(category, PageRequest.of(0, 10));
    }

    public Page<Article> findByAuthorsNameUsingCustomQueryAnnotation(String name) {
        return articleRepository.findByAuthorsNameUsingCustomQueryAnnotation(name, PageRequest.of(0, 10));
    }

    public Page<Article> searchOnAllFields(String query) {
        return articleRepository.searchOnAllFields(query, PageRequest.of(0, 10));
    }
}
