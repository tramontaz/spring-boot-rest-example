package net.chemodurov.tutorial.spring_boot_rest_example.repository;

import net.chemodurov.tutorial.spring_boot_rest_example.entity.Article;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ArticleRepository extends CrudRepository<Article, Long> {
    List<Article> findByTitle(String title);
    List<Article> findDistinctByCategory(String category);
    List<Article> findByTitleAndCategory(String title, String category);
}
