//package com.Hackathon.AiHealthManagement.Services.impl;
//
//import org.springframework.ai.mistralai.MistralAiChatModel;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.Hackathon.AiHealthManagement.Models.HealthData;
//import com.Hackathon.AiHealthManagement.Repositories.RecommendationRepository;
//import com.Hackathon.AiHealthManagement.Services.RecommendationService;
//
//@Service
//public class RecommendationServiceImpl implements RecommendationService{
//
//	@Autowired
//	private  MistralAiChatModel chatModel;
//	
//	
//	@Override public String getDietRecommendation(String username, HealthData data) { String prompt = String.format("Provide a personalized diet recommendation for a user with the following details: Name: %s, Age: %d, Weight: %.1f, Height: %.1f, Medical Condition: %s", 
//			
//			username, data.getAge(), data.getWeight(), data.getHeight(), data.getHealthCondition()); return chatModel.call(prompt); }
//	@Override
//	public String getHealthRecommendation(String username, HealthData data) {
//		String prompt = String.format("Provide a personalized health  recommendation for a user with the following details: Name: %s , Age: %d , Weight: %.1f , Height: %.1f,Medical Condition: %s", username,data.getAge(),
//				data.getWeight(),data.getHealthCondition());
//	
//		return (chatModel.call(prompt));
//	}
//
//	@Override
//	public String getExerciseRecommendation(String username, HealthData data) {
//		String prompt = String.format("Provide a personalized Exercise recommendation for a user with the following details: Name: %s , Age: %d , Weight: %.1f , Height: %.1f,Medical Condition: %s", username,data.getAge(),
//				data.getWeight(),data.getHealthCondition());
//		return chatModel.call(prompt);
//	}
//
//	@Override
//	public String getMotivationalQuote(String username, HealthData data) {
//		String prompt = String.format(
//	            "Provide a motivational quote for a user having medical condition %s and needing encouragement for their health journey.",
//	            data.getHealthCondition()
//	        );
//		
//		return chatModel.call(prompt);
//	}
//	
//
//}
package com.Hackathon.AiHealthManagement.Services.impl;

import java.util.List;

import org.springframework.ai.mistralai.MistralAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Hackathon.AiHealthManagement.Models.HealthData;
import com.Hackathon.AiHealthManagement.Models.Recommendation;
import com.Hackathon.AiHealthManagement.Models.User;
import com.Hackathon.AiHealthManagement.Repositories.RecommendationRepository;
import com.Hackathon.AiHealthManagement.Repositories.UserRepository;
import com.Hackathon.AiHealthManagement.Services.RecommendationService;

@Service
public class RecommendationServiceImpl implements RecommendationService {

    @Autowired
    private MistralAiChatModel chatModel;
    
    @Autowired
    private RecommendationRepository recommendationRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public String getDietRecommendation(String username, HealthData data) {
        String prompt = String.format("Provide a brief,personal and concise diet recommendation for a user with the following details: Name: %s, Age: %d, Weight: %.1f, Height: %.1f, Medical Condition: %s", 
            username, data.getAge(), data.getWeight(), data.getHeight(), data.getHealthCondition());
        
        return chatModel.call(prompt);
    }

    @Override
    public String getHealthRecommendation(String username, HealthData data) {
        String prompt = String.format("Provide a brief,personal and concise diet recommendation for a user with the following details: Name: %s, Age: %d, Weight: %.1f, Height: %.1f, Medical Condition: %s", 
            username, data.getAge(), data.getWeight(), data.getHeight(), data.getHealthCondition());
    
        return chatModel.call(prompt);
    }

    @Override
    public String getExerciseRecommendation(String username, HealthData data) {
        String prompt = String.format("Provide a brief,personal and concise diet recommendation for a user with the following details: Name: %s, Age: %d, Weight: %.1f, Height: %.1f, Medical Condition: %s", 
            username, data.getAge(), data.getWeight(), data.getHeight(), data.getHealthCondition());
        
        return chatModel.call(prompt);
    }

    @Override
    public String getMotivationalQuote(String username, HealthData data) {
        String prompt = String.format("Provide a motivational quote for a user having a medical condition %s and needing encouragement for their health journey.", 
            data.getHealthCondition());
        
        return chatModel.call(prompt);
    }
    @Transactional
    @Override
    public List<Recommendation> getRecommendation(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Fetch and return recommendations associated with the user
        return recommendationRepository.findByUser(user);
    }
    


}
