package com.Hackathon.AiHealthManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.Hackathon.AiHealthManagement.Models.HealthData;
import com.Hackathon.AiHealthManagement.Models.Recommendation;
import com.Hackathon.AiHealthManagement.Models.User;
import com.Hackathon.AiHealthManagement.Repositories.UserRepository;
import com.Hackathon.AiHealthManagement.Services.impl.HealthServiceImpl;
import com.Hackathon.AiHealthManagement.Services.impl.RecommendationServiceImpl;

@Controller
public class MainController {
    
    @Autowired
    HealthServiceImpl healthService;

    @Autowired
    RecommendationServiceImpl recommendationService;

    @Autowired
    UserRepository userRepo;

    @GetMapping("/health/{userId}")
    public String healthPage(@PathVariable Long userId, Model model) {
        // Fetch the health data
        User user = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        List<HealthData> healthList = healthService.getAllHealthDataForUser(user);
        
        // Fetch recommendations for the user
        List<Recommendation> recommendations = recommendationService.getRecommendation(userId);
        
        model.addAttribute("healthList", healthList);
        model.addAttribute("recommendations", recommendations);

        return "health"; 
    }
}
