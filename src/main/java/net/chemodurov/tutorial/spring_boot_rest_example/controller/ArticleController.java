package net.chemodurov.tutorial.spring_boot_rest_example.controller;

import net.chemodurov.tutorial.spring_boot_rest_example.entity.Article;
import net.chemodurov.tutorial.spring_boot_rest_example.service.IArticleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("user")
public class ArticleController {
    @Autowired
    private IArticleService articleService;

    //Fetches article by id
    @GetMapping(value = "article/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ArticleInfo> getArticleById(@PathVariable("id") Integer id) {
        ArticleInfo ob = new ArticleInfo();
        BeanUtils.copyProperties(articleService.getArticleById(id), ob);
        return new ResponseEntity<>(ob, HttpStatus.OK);

    }

    //Fetches all articles
    @GetMapping(value = "articles", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<ArticleInfo>> getAllArticles() {
        List<ArticleInfo> responseArticleList = new ArrayList<>();
        List<Article> articleList = articleService.getAllArticles();
        for (Article anArticleList : articleList) {
            ArticleInfo ob = new ArticleInfo();
            BeanUtils.copyProperties(anArticleList, ob);
            responseArticleList.add(ob);
        }
        return new ResponseEntity<>(responseArticleList, HttpStatus.OK);
    }

    //Creates a new article
    @PostMapping(value = "article", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> addArticle(@RequestBody ArticleInfo articleInfo, UriComponentsBuilder builder) {
        Article article = new Article();
        BeanUtils.copyProperties(articleInfo, article);
        boolean flag = articleService.addArticle(article);
        if (!flag) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/article/{id}").buildAndExpand(article.getArticleId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    //Updates article
    @PutMapping(value = "article", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ArticleInfo> updateArticle(@RequestBody ArticleInfo articleInfo) {
        Article article = new Article();
        BeanUtils.copyProperties(articleInfo, article);
        articleService.updateArticle(article);

        ArticleInfo ob = new ArticleInfo();
        BeanUtils.copyProperties(article, ob);
        return new ResponseEntity<>(ob, HttpStatus.OK);
    }

    //Deletes article by id
    @DeleteMapping(value = "article/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> deleteArticle(@PathVariable("id") Integer id) {
        articleService.deleteArticle(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
