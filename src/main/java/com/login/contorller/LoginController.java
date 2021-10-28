package com.login.contorller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.login.service.LoginService;

@Controller
@SessionAttributes("name")
public class LoginController {
	
	/*
	@RequestMapping("/login")
	// @ResponseBody
	public String loginMessage() {
		// System.out.println("@RequestMapping(\"/login\")");
		return "login";
	}
	*/
	
	/*
	@RequestMapping("login")
	 
	public String loginMessage(@RequestParam String name, ModelMap model) {
		// http://localhost:8080/login?name=John
		model.put("name", name);
		return "login";
	}
	
	
	@RequestMapping(value="login", method = RequestMethod.GET)
	public String showLoginPage(ModelMap model) {
		System.out.println("showLoginPage: " + model);
		return "login";
	}
	
	@RequestMapping(value="login", method = RequestMethod.POST)
	public String showWelcomePage(ModelMap model, @RequestParam String name) {
		System.out.println("showWelcomePage: " + model);
		System.out.println("showWelcomePage: " + name);
		model.put("name", name);
		return "welcome";
	}
	*/
	
	@Autowired
	LoginService service;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String showLoginPage(ModelMap model) {
		return "/login/login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String showWelcomePage(ModelMap model, @RequestParam String name, @RequestParam String password) {
		boolean isValidUser = service.validateUser(name, password);
		
		if(!isValidUser) {
			model.put("errorMessage", "Invalid Credentials");
			return "/login/login";
		}
		
		model.put("name", name);
		model.put("password", password);
		
		return "login/welcome";
	}

}
