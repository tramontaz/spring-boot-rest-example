package net.chemodurov.tutorial.spring_boot_rest_example.service;

import net.chemodurov.tutorial.spring_boot_rest_example.entity.Article;

import java.util.List;

public interface IArticleService {
    List<Article> getAllArticles();
    Article getArticleById(long articleId);
    boolean addArticle(Article article);
    void updateArticle(Article article);
    void deleteArticle(long articleId);
}
