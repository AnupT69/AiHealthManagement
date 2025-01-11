package com.Hackathon.AiHealthManagement.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Hackathon.AiHealthManagement.Models.HealthData;
import com.Hackathon.AiHealthManagement.Models.Recommendation;
import com.Hackathon.AiHealthManagement.Models.User;



public interface RecommendationRepository extends JpaRepository<Recommendation, Long>{

	Recommendation findByHealthData(HealthData health_data);



}
