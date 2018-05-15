package net.chemodurov.tutorial.spring_boot_rest_example.entity;


import javax.persistence.*;

@Entity
@Table(name="articles")
public class Article {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "article_id")
    private long articleId;
    @Column(name = "title")
    private String title;
    @Column(name = "category")
    private String category;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

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
