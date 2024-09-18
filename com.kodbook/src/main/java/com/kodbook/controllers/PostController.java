package com.kodbook.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.kodbook.entities.Post;
import com.kodbook.entities.User;
import com.kodbook.services.PostService;
import com.kodbook.services.UserService;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
public class PostController {

	@Autowired
	PostService postService;
	
	@Autowired
	UserService service;

	@PostMapping("/createPost")
	public String createPost(@RequestParam String caption, @RequestParam MultipartFile photo) {

		Post post = new Post();
		post.setCaption(caption);
		try {
			post.setPhoto(photo.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		postService.createPost(post);

		return "home";
	}
	
	@GetMapping("/newsFeed")
	public String newsFeed(Model model) {
		List<Post> allPosts = postService.fetchAllPosts();
		model.addAttribute("allPosts", allPosts);
		return "home";
	}
	
	@GetMapping("/likePost")
	public String likePost(@RequestParam Long id, Model model) {
		Post post = postService.getPost(id);
		post.setLikes(post.getLikes() + 1);
		postService.updateLikes(post);
		
		List<Post> allPosts = postService.fetchAllPosts();
		model.addAttribute("allPosts", allPosts);
		return "home"; 
	}
	
	@GetMapping("/addComment")
	public String addComment(@RequestParam Long id,@RequestParam String comment,Model model) {
		Post post = postService.getPost(id);
		List<String> comments = post.getComments();
		if(comments == null) {
			comments = new ArrayList<String>();
		}
		comments.add(comment);
		post.setComments(comments);
		postService.updateComments(post);
		
		
		List<Post> allPosts = postService.fetchAllPosts();
		model.addAttribute("allPosts", allPosts);
		return "home"; 
	}
	

}
