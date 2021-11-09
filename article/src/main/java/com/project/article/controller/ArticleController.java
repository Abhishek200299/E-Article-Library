package com.project.article.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.project.article.exception.ArticleNotFoundException;
import com.project.article.model.Article;
import com.project.article.model.Login;
import com.project.article.repository.ArticleRespostitory;
import com.project.article.repository.Repo;

import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
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
    
    
	@GetMapping("/")
	public String welcome(){
		return "index";
	}

	@RequestMapping("/createarticle")
	public ModelAndView showform(){

		return new ModelAndView("createarticle","command",new Article());
	}

	@RequestMapping("/editarticle")
	public ModelAndView showeditform(){

		return new ModelAndView("editarticle","command",new Article());
	}

	@RequestMapping(value="/save",method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("art") Article art){
		if(articleRepository.findById(art.getId()).isPresent()){
			String message = "already present.";
			return new ModelAndView("/errorpage","message",message);
		}else {
			articleRepository.save(art);
			return new ModelAndView("redirect:/viewarticle");
		}
	}

	@RequestMapping(value="/editsave",method = RequestMethod.POST)
	public ModelAndView editsave(@ModelAttribute("art") Article art){
			articleRepository.save(art);
			return new ModelAndView("redirect:/viewarticle");
	}

	@RequestMapping(value = "/viewarticle")
	public ModelAndView viewarticle(){
		ArrayList<Article> articles= (ArrayList<Article>) articleRepository.findAll();
		return new ModelAndView("viewarticle","articles",articles);
	}
	
	@GetMapping(value = "/deletearticle/{id}")
	public String getArticleById(@PathVariable long id){
		articleRepository.deleteById(id);
		return ("redirect:/viewarticle");
	}

//	@GetMapping("/article/{category}")
//	public ModelAndView getArticleByCategory(@PathVariable String category) {
//		ArrayList<Article> articles= (ArrayList<Article>) articleRepository.findByCategory(category);
//		return new ModelAndView("viewarticle","articles",articles);
//	}

	@PostMapping("/editthearticle")
	public ModelAndView editArticleById(@RequestParam("id") long id){
		if(articleRepository.findById(id).isPresent()) {
			Article article = articleRepository.findById(id).orElseThrow(() -> new ArticleNotFoundException("Article not exist: " + id));
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.addObject("command", new Article());
			modelAndView.addObject("article", article);
			modelAndView.setViewName("editingarticle");
			return modelAndView;
		}else{
			String message = "not found.";
			return new ModelAndView("/errorpage","message",message);
		}

		
	}

}
