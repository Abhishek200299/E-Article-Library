package com.project.article.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.article.exception.ArticleNotFoundException;
import com.project.article.model.Article;
import com.project.article.model.Login;
import com.project.article.repository.Repo;
import com.project.article.repository.ArticleRespostitory;

@RestController
@RequestMapping("v1")
public class ArticleController {
	
	@Autowired
	private ArticleRespostitory articleRepository;
	
	@Autowired
	private Repo repo;
	
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
			
	}
	
	
	@RequestMapping(value = "/login/create", method = RequestMethod.POST)
    public String validateUser(Login login) {
		
		Login log = repo.findByUsername(login.getUsername());
		if (log.getPassword().equals(login.getPassword())) {
			if(log.getRole().equals("Author")) {
				return "author";
			}
			else if (log.getRole().equals("Reader")) {
				return "reader";
			}
		}
		else {
			return "error";
		}
		return "login";

		
	}
	
	@PostMapping("/article/create")
	public ResponseEntity<Article> addEmployee(@RequestBody Article article) {
		articleRepository.save(article);
		return new ResponseEntity<Article>(HttpStatus.CREATED);	
	}
	
	@GetMapping("/article/{id}")
	public ResponseEntity<Article> getArticleById(@PathVariable Long id) {
		Article article= articleRepository.findById(id).orElseThrow(() -> new ArticleNotFoundException("Article not exist: "+id));
		return ResponseEntity.ok(article);
	}
	
	@GetMapping("/article/category/{category}")
	public Article[] getArticleByCategory(@PathVariable String category) {
		Article[] article = null;
		try {
			article = articleRepository.findByCategory(category);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return article;
	}
	
	@PutMapping("/article/edit/{id}")
	public String editArticleById(@PathVariable Long id,@RequestBody Article e) {
		Article article= articleRepository.findById(id).orElseThrow(() -> new ArticleNotFoundException("Article not exist: "+id));
		article.setAuthorname(e.getAuthorname());
		article.setCategory(e.getCategory());
		article.setContent(e.getContent());
		article.setDescription(e.getDescription());
		article.setTitle(e.getTitle());
		article.setCreatedDate(e.getCreatedDate());
		articleRepository.save(article);
		String eu="Successfully updated the Employee with id : "+id+".";
		return eu;
	}
	
	@DeleteMapping("/article/{id}")
	public String deleteArticleById(@PathVariable Long id) {
		Article article= articleRepository.findById(id).orElseThrow(() -> new ArticleNotFoundException("Article not exist: "+id));
		articleRepository.delete(article);
		String eu="Successfully deleted the Employee with id : "+id+".";
		return eu;
	}
	
	
	

}
