package com.Hackathon.AiHealthManagement.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
//import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
public class Recommendation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Lob
	private String dietRecommendation;

	@Lob
	private String healthRecommendation;

	@Lob
	private String exerciseRecommendation;

	@Lob 
	private String motivationQuote;
	
	
	
	
	@OneToOne
	@JoinColumn(name="health_data_id",referencedColumnName = "id")
	@JsonBackReference
	private HealthData healthData;
	

}
