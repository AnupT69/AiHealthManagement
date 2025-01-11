package com.Hackathon.AiHealthManagement.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Hackathon.AiHealthManagement.Models.User;



public interface UserRepository extends JpaRepository<User, Long>{
	

}
