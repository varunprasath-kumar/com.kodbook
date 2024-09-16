package com.kodbook.services;

import java.util.List;

import com.kodbook.entities.Post;

public interface PostService {

	void createPost(Post post);

	List<Post> fetchAllPosts();

	Post getPost(Long id);

	void updateLikes(Post post);

	void updateComments(Post post);

	
	

}
