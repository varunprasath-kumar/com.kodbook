package com.kodbook.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.kodbook.entities.Post;
import com.kodbook.services.PostService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class PostController {

	@Autowired
	PostService service;

	@PostMapping("/createPost")
	public String createPost(@RequestParam String caption, @RequestParam MultipartFile photo) {

		Post post = new Post();
		post.setCaption(caption);
		try {
			post.setPhoto(photo.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		service.createPost(post);

		return "home";
	}
	
	@GetMapping("")
	public String fetchAllPosts(Model model) {
		List<Post> allPosts = service.fetchAllPosts();
		model.addAttribute("allPosts", allPosts);
		return "home";
	}
	

}
