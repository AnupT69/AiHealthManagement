package com.Hackathon.AiHealthManagement.Services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Hackathon.AiHealthManagement.Models.HealthData;
import com.Hackathon.AiHealthManagement.Models.User;
import com.Hackathon.AiHealthManagement.Repositories.HealthRepository;
import com.Hackathon.AiHealthManagement.Services.HealtService;

@Service
public class HealthServiceImpl implements HealtService{
	
	@Autowired
	HealthRepository repo;

	@Override
	public HealthData createHealthForUser(User user, Float weight, Float height, int age, int sleepHours,
			String exercise, String healthCondition) {
		HealthData data = new HealthData();
		data.setAge(age);
		data.setExercise(exercise);
		data.setHealthCondition(healthCondition);
		data.setWeight(weight);
		data.setSleepHours(sleepHours);
		data.setHeight(height);
		data.setUser(user);
		
		repo.save(data);
		
		return data;
	}

	@Override
	public HealthData updateHealthForUser(HealthData data) {
		HealthData existingData = repo.findById(data.getId()).orElseThrow(()->new RuntimeException("Health Data is not found"));
		
		existingData.setAge(data.getAge());
		existingData.setExercise(data.getExercise());
		existingData.setHealthCondition(data.getHealthCondition());
		existingData.setHeight(data.getHeight());
		existingData.setSleepHours(data.getSleepHours());
		existingData.setWeight(data.getWeight());
		
		return repo.save(existingData);
	}

	@Override
	public void deleteAllHealthRecordForUser(User user) {
		
		if(user==null) {
			throw new IllegalArgumentException("User cannot be null");
		}
		
		List<HealthData> dataList = repo.findByUser(user);
		
		if(dataList.isEmpty()) {
			throw new RuntimeException("No health data found for the user");
			
		}
		
		repo.deleteAll(dataList);
		
}
	@Override
	public List<HealthData> getAllHealthDataForUser(User user){
		if(user==null) {
			throw new IllegalArgumentException("User cannot be null");
		}
		List<HealthData> dataList = repo.findByUser(user);
		
		if(dataList.isEmpty()) {
			return new ArrayList<HealthData>();
		}
		
		
		return dataList;
	}

	public void deleteHealthRecord(HealthData data) {
		// TODO Auto-generated method stub
		
	}

	
		
	

}
