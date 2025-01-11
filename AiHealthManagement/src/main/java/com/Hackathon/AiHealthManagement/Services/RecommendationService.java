package com.Hackathon.AiHealthManagement.Services;

import java.util.List;

import com.Hackathon.AiHealthManagement.Models.HealthData;
import com.Hackathon.AiHealthManagement.Models.Recommendation;

public interface RecommendationService {
	
	String getDietRecommendation(String username , HealthData data);
	
	String getHealthRecommendation(String username ,HealthData data);
	
	String getExerciseRecommendation(String username,HealthData data);
	
	String getMotivationalQuote(String username, HealthData data);

	Recommendation getRecommendation(Long userId);

	
	
}
