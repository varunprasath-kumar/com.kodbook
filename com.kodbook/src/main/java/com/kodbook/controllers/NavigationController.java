package com.kodbook.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;





@Controller
public class NavigationController {
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/openSignUp")
	public String openSignUp() {
		return "signUp";
	}

	@GetMapping("/openResetPassword")
	public String openResetPassword() {
		return "forgetPassword";
	}
	
	@GetMapping("/createNewPost")
	public String createNewPost() {
		return "createPost";
	}
	

} 
