package com.project.article.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.project.article.exception.ArticleNotFoundException;
import com.project.article.model.Article;
import com.project.article.model.Login;
import com.project.article.repository.Repo;
import com.project.article.repository.ArticleRepo;
import com.project.article.repository.ArticleRespostitory;

@Controller

public class ArticleController {
	
	@Autowired
	private ArticleRespostitory articleRepository;
	
	@Autowired
	private Repo repo;
	
	@Autowired
	private ArticleRepo arepo;
	
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
			
	}
	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
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
	
	@RequestMapping(value="/Fiction", method= RequestMethod.GET)
	public ModelAndView fictionPage() {
		List<Article> li = arepo.findByCategory("Fiction");
		ArrayList<String> articleTitleList = new ArrayList<>(); 
		for (Article x : li) {
			articleTitleList.add(x.getTitle());
		}
	    ModelAndView modelAndView = new ModelAndView("Fiction");
	    modelAndView.addObject("titleList", articleTitleList);
	    return modelAndView;

	}
	
	@RequestMapping(value="/Non-Fiction", method= RequestMethod.GET)
	public ModelAndView nonFictionPage() {
		List<Article> li = arepo.findByCategory("Non-Fiction");
		ArrayList<String> articleTitleList = new ArrayList<>(); 
		for (Article x : li) {
			articleTitleList.add(x.getTitle());
		}
	    ModelAndView modelAndView = new ModelAndView("Non-Fiction");
	    modelAndView.addObject("titleList", articleTitleList);
	    return modelAndView;

	}
	
	@RequestMapping(value="/Politics", method= RequestMethod.GET)
	public ModelAndView politicsPage() {
		List<Article> li = arepo.findByCategory("Politics");
		ArrayList<String> articleTitleList = new ArrayList<>(); 
		for (Article x : li) {
			articleTitleList.add(x.getTitle());
		}
	    ModelAndView modelAndView = new ModelAndView("Politics");
	    modelAndView.addObject("titleList", articleTitleList);
	    return modelAndView;

	}
	
	@RequestMapping(value="/Wildlife", method= RequestMethod.GET)
	public ModelAndView wildlifePage() {
		List<Article> li = arepo.findByCategory("Wildlife");
		ArrayList<String> articleTitleList = new ArrayList<>(); 
		for (Article x : li) {
			articleTitleList.add(x.getTitle());
		}
	    ModelAndView modelAndView = new ModelAndView("Wildlife");
	    modelAndView.addObject("titleList", articleTitleList);
	    return modelAndView;

	}
	
	@RequestMapping(value="/Science&Tech", method= RequestMethod.GET)
	public ModelAndView scienceTechPage() {
		List<Article> li = arepo.findByCategory("Science and Technology");
		ArrayList<String> articleTitleList = new ArrayList<>(); 
		for (Article x : li) {
			articleTitleList.add(x.getTitle());
		}
	    ModelAndView modelAndView = new ModelAndView("Science&Tech");
	    modelAndView.addObject("titleList", articleTitleList);
	    return modelAndView;

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
