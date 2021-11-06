package com.project.article.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.article.model.Article;


@Repository
public interface ArticleRespostitory extends JpaRepository<Article, Long>{

	public Article[] findByCategory(String category);

}
