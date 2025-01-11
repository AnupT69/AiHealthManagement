package com.Hackathon.AiHealthManagement.Services;

import com.Hackathon.AiHealthManagement.Models.User;

public interface UserService {
	
    User addNewUser(String name , String email , String password);

	User getUserById(Long userId);
    
    
	
	
	

}
