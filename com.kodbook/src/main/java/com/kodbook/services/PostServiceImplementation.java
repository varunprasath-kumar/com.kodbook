package com.kodbook.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodbook.entities.Post;
import com.kodbook.repositories.PostRepository;

@Service
public class PostServiceImplementation implements PostService {

	@Autowired
	PostRepository repo;

	@Override
	public void createPost(Post post) {
		repo.save(post);
	}

	public List<Post> fetchAllPosts() {
		return repo.findAll();

	}

	// getting id for likes
	public Post getPost(Long id) {
		return repo.findById(id).get();
	}

	// updating the likes
	public void updateLikes(Post post) {
		repo.save(post);
	}

	@Override
	public void updateComments(Post post) {
		repo.save(post);
	}

	

}
