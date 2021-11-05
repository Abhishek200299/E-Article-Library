package com.project.article.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.project.article.model.Login;
import com.project.article.repository.Repo;



@Controller

public class ArticleController {
	
	@Autowired
	private Repo repo;
	
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
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
//		String x = new String();
//			List<Login> li = repo.findAll();
////			ArrayList<HashMap<String,String>> list = new ArrayList<>();
//			HashMap<String, HashMap<String, String>> map2 = new HashMap<String, HashMap<String, String>>() ;
//			for(Login name:li) {
//				HashMap<String, String> map1 = new HashMap<>();
//				map1.put("Password", name.getPassword());
//				map1.put("Role", name.getRole());
//				map2.put(name.getUsername(),map1);
//			}
//			HashMap<String, String> map3 = new HashMap<>();
//			for(Login name:li) {
//				
//				map3.put(name.getUsername(),name.getRole());
//
//			}
////			System.out.println(map2);
////			System.out.println(login.getUsername());
//			
//
//
//			for (Entry<String, HashMap<String, String>> m : map2.entrySet()) {
//				
//					if (m.getKey().equals(login.getUsername())) {
//						System.out.println("Running.....");
//						for (Entry<String, String> n: m.getValue().entrySet()) {
//							if (n.getKey().equals("Password")) {
//								System.out.println("Success.....1");
//								if (n.getValue().equals(login.getPassword())) {
//									System.out.println("Success.....2");
//									for (Entry<String, String> x: map3.entrySet()) {
//										if (x.getKey().equals(login.getUsername())) {
//											System.out.println("Success.....3");
//											if (x.get)
////										if (n.getValue().equals("Author")) {
////											System.out.println("Success.....4");
////											x="author";
//												}
//											}
//									}
//								}
//							}
//						
////										else if (n.getValue().equals("Reader")) {
////											x="reader";
////										}
////										else {
////											x="error";
////										}
////									
////								}
////								
////							}
////								else {
////									x="error";
////								}
//								}
//							}
//						}
//					}
//			}
	







	


	
	


