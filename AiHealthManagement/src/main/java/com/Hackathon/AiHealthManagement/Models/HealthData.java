package com.Hackathon.AiHealthManagement.Models;



import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
public class HealthData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Float weight;
	
	private Float height;
	
	private int age;
	
	private int sleepHours;
	
	private String exercise;
	
	private String healthCondition;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	@JsonBackReference
	private User user;
	
	

}
