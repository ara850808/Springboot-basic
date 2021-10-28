package com.login.service;

import org.springframework.stereotype.Component;

@Component
public class LoginService {
		
	public boolean validateUser(String userid, String password) {
		return userid.equals("Donguk") && password.equals("1");
	}	
	
}
