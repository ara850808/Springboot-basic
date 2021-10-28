package com.article.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.articleservice.ArticleService;

@Controller
@SessionAttributes("name")
public class ArticleController {
	
	@Autowired
	ArticleService service;
	
	@RequestMapping(value="/list-articles", method=RequestMethod.GET)
	public String showTodos(ModelMap model) {
		String name = (String) model.get("name");
		model.put("articles", service.retrieveArticles(name));		
		return "article/list-articles";
	}
	
	@RequestMapping(value="/add-article", method=RequestMethod.GET)
	public String showAddTodoPage(ModelMap model) {
		return "todo/todo";
	}
	
	@RequestMapping(value="/delete-article", method=RequestMethod.GET)
	public String deleteTodo(@RequestParam int id) {
		service.deleteArticle(id);
		return "redirect:/article/list-articles";
	}
	
	@RequestMapping(value="/add-article", method=RequestMethod.POST)
	public String addArticle(ModelMap model, @RequestParam String title, @RequestParam String desc) {
		service.addArticle((String) model.get("name"), title, desc, new Date());
		return "redirect:/article/list-articles";
	}
}
