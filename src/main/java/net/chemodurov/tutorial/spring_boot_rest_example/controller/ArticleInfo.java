package net.chemodurov.tutorial.spring_boot_rest_example.controller;

import com.fasterxml.jackson.annotation.JsonInclude;

public class ArticleInfo {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private long articleId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String title;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String category;

    public long getArticleId() {
        return articleId;
    }

    public void setArticleId(long articleId) {
        this.articleId = articleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
