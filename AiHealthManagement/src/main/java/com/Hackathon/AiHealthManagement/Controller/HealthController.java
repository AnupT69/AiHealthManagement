package com.Hackathon.AiHealthManagement.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Hackathon.AiHealthManagement.Models.HealthData;
import com.Hackathon.AiHealthManagement.Models.User;
import com.Hackathon.AiHealthManagement.Repositories.HealthRepository;
import com.Hackathon.AiHealthManagement.Repositories.UserRepository;
import com.Hackathon.AiHealthManagement.Services.impl.HealthServiceImpl;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/health")
public class HealthController {
	
	@Autowired
	private HealthServiceImpl service;
	
	@Autowired
	private HealthRepository healthRepo;
	
	@Autowired
	private UserRepository userRepo;

	@PostMapping("/create")
	public HealthData createHealthRecord(@RequestParam Long user_id ,@org.springframework.web.bind.annotation.RequestBody HealthData data){
	    User user = userRepo.findById(user_id).orElseThrow(()->new RuntimeException("user not found"));
	    
	    HealthData newData = service.createHealthForUser(user, data.getWeight(), data.getHeight(), data.getAge(), data.getSleepHours(), data.getExercise(),data.getHealthCondition());
	    return newData;
	}
	
	 @PutMapping("/update/{id}")
	    public HealthData updateHealthRecord(
	            @PathVariable Long id,
	            @RequestBody HealthData healthData) {
	        healthData.setId(id); // Ensure the ID is set in the provided data
	        HealthData updatedData = service.updateHealthForUser(healthData);
	        return updatedData;
	    }
	 
	 @DeleteMapping("/delete/{id}")
	    public String deleteHealthRecord(@PathVariable Long id) {
	        HealthData data = healthRepo.findById(id).orElseThrow(()->new RuntimeException("Health Data not found"));
	        
	        service.deleteHealthRecord(data);
	        return "Health record deleted successfuly";
	    }
	 
	 @DeleteMapping("/delete-all/{userId}")
	    public String deleteAllHealthRecords(@PathVariable Long userId) {
	        User user = userRepo.findById(userId).orElseThrow(()->new RuntimeException("User is not found")); // Replace with actual user fetch logic
	        
	        service.deleteAllHealthRecordForUser(user);
	        return "All health records deleted";
	    }
	
	 @GetMapping("/user/{userId}")
	    public List<HealthData> getAllHealthRecords(@PathVariable Long userId) {
	      
		 User user = userRepo.findById(userId).orElseThrow(()->new RuntimeException("User is not found"));
	        
	        List<HealthData> healthDataList = service.getAllHealthDataForUser(user);
	        return healthDataList;
	    }
	 

	 @GetMapping("/{id}")
	 public HealthData getHealthRecordById(@PathVariable Long id) {
	     HealthData data = healthRepo.findById(id)
	         .orElseThrow(() -> new RuntimeException("Health data not found"));
	     return data;
	 }

	

}
