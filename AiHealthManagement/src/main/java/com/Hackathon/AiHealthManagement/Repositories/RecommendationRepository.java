package com.Hackathon.AiHealthManagement.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.Hackathon.AiHealthManagement.Models.Recommendation;
import com.Hackathon.AiHealthManagement.Models.User;



public interface RecommendationRepository extends JpaRepository<Recommendation, Long>{

	List<Recommendation> findByUser(User user);

}
