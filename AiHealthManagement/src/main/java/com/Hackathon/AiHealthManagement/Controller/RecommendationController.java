
package com.Hackathon.AiHealthManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import com.Hackathon.AiHealthManagement.Models.HealthData;
import com.Hackathon.AiHealthManagement.Models.Recommendation;
import com.Hackathon.AiHealthManagement.Models.User;
import com.Hackathon.AiHealthManagement.Repositories.HealthRepository;
import com.Hackathon.AiHealthManagement.Repositories.RecommendationRepository;
import com.Hackathon.AiHealthManagement.Repositories.UserRepository;
import com.Hackathon.AiHealthManagement.Services.impl.RecommendationServiceImpl;

@RestController
@RequestMapping("/api/recommendations")
public class RecommendationController {

    @Autowired
    private RecommendationServiceImpl recommendationService;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private HealthRepository healthRepo;

    @Autowired
    private RecommendationRepository recommendationRepo;

    @PostMapping("/generate/{userId}/{healthId}")
    public Recommendation generateRecommendations(
            @PathVariable Long userId,
            @PathVariable Long healthId) {

        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        HealthData healthData = healthRepo.findById(healthId)
                .orElseThrow(() -> new RuntimeException("Health data not found"));

        Recommendation recommendation = new Recommendation();
        recommendation.setUser(user);
        recommendation.setDietRecommendation(recommendationService.getDietRecommendation(user.getName(), healthData));
        recommendation.setHealthRecommendation(recommendationService.getHealthRecommendation(user.getName(), healthData));
        recommendation.setExerciseRecommendation(recommendationService.getExerciseRecommendation(user.getName(), healthData));
        recommendation.setMotivationQuote(recommendationService.getMotivationalQuote(user.getName(), healthData));

        recommendationRepo.save(recommendation);

        return recommendation;
    }
    
    @Transactional
    @GetMapping("/{user_id}")
    public List<Recommendation> getRecommendation(@PathVariable Long user_id){
    	
    	User user = userRepo.findById(user_id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        List<Recommendation> recommendations = recommendationRepo.findByUser(user);
        if (recommendations.isEmpty()) {
            throw new RuntimeException("No recommendation for user"); 
        }

        return recommendations;
    	
    }
    @GetMapping("/recommendation/{recommendationId}")
    public Recommendation getRecommendationById(@PathVariable Long recommendationId) {
        Recommendation recommendation = recommendationRepo.findById(recommendationId)
                .orElseThrow(() -> new RuntimeException("Recommendation not found"));
        return recommendation;
    }
    

}
