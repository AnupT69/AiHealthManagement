package com.Hackathon.AiHealthManagement.Services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Hackathon.AiHealthManagement.Models.User;
import com.Hackathon.AiHealthManagement.Repositories.UserRepository;
import com.Hackathon.AiHealthManagement.Services.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository repo;
	@Override
	public User addNewUser(String name, String email, String password) {
		User data = new User();
		data.setEmail(email);
		data.setName(name);
		data.setPassword(password);
		repo.save(data);
		return data;
	}
	@Override
	public User getUserById(Long userId) {
		Optional<User> user = repo.findById(userId);
		if (user.isPresent()) {
			return user.get();
		} else {
			
			throw new RuntimeException("User not found with id: " + userId);
		}
	}
	

}
