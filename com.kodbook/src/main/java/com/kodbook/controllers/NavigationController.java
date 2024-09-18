package com.kodbook.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kodbook.entities.User;

import com.kodbook.services.UserService;

import jakarta.servlet.http.HttpSession;
@Controller
public class NavigationController {
	
	@Autowired
	UserService service;

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

	@GetMapping("/openEditProfile")
	public String openEditProfile() {
		return "editProfile";
	}

	@GetMapping("/goHome")
	public String login() {
		return "home";
	}

	
	@GetMapping("/openMyProfile")
	public String openMyProfile(Model model, HttpSession session) {
		String username = (String) session.getAttribute("username");
		User user = service.getUser(username);
		model.addAttribute("user", user);
		return "myProfile";
	}
	

}
