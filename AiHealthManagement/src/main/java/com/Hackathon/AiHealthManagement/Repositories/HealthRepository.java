package com.Hackathon.AiHealthManagement.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Hackathon.AiHealthManagement.Models.HealthData;
import com.Hackathon.AiHealthManagement.Models.User;


public interface HealthRepository extends JpaRepository<HealthData, Long>{
	
	 List<HealthData> findByUser(User user);	

}
