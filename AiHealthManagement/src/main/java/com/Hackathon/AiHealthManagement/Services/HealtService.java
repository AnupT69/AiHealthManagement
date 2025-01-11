package com.Hackathon.AiHealthManagement.Services;

import java.util.List;

import com.Hackathon.AiHealthManagement.Models.HealthData;
import com.Hackathon.AiHealthManagement.Models.User;




public interface HealtService {
	HealthData createHealthForUser(User user , Float weight , Float height , int age , int sleepHours, String exercise , String healthCondition);

	HealthData updateHealthForUser(HealthData data);
	
	
	List<HealthData> getAllHealthDataForUser(User user);
	
	void deleteAllHealthRecordForUser(User user);
	
	
	

	
}


