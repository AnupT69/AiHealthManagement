package com.Hackathon.AiHealthManagement.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
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
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	@JsonBackReference
	private User user;
	
	

}
