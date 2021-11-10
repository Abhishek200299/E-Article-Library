package com.project.article.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.article.model.Article;
import com.project.article.model.Login;

@Repository 
public interface ArticleRepo extends JpaRepository<Article,Integer>{
	@Query(value="select * from article where category = ?1", nativeQuery = true)
	public List<Article> findByCategory(String cat); 
}