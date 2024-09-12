package com.kodbook.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodbook.entities.User;
import com.kodbook.repositories.UserRepository;

@Service
public class UserServiceImplementation implements UserService {

	@Autowired
	UserRepository repo;

	public boolean userExists(String username, String email) {
		User user1 = repo.findByUsername(username);
		User user2 = repo.findByEmail(email);
		if (user1 != null || user2 != null) {
			return true;
		} else {
			return false;
		}

	}

	public void addUser(User user) {
		repo.save(user);
	}

	@Override
	public boolean validateUser(String username, String password) {
		String dbPass = repo.findByUsername(username).getPassword();
		if (password.equals(dbPass)) {
			return true;
		}
		return false;
	}

	@Override
	public String updatePassword(String email, String newPassword, String confirmNewPassword, User user) {

		User existingUser = repo.findByEmail(email);
		if (existingUser != null) {
			if (newPassword.equals(confirmNewPassword)) {
				existingUser.setPassword(confirmNewPassword);
				repo.save(existingUser);
				System.out.println("Password Updated successfully");
				return "index";
			} else {
				System.out.println("Password not Match");
			}

		}
		System.out.println("User not found");
		return "index";

	}

}
