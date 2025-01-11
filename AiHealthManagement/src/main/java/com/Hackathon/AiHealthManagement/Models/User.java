package com.Hackathon.AiHealthManagement.Models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	
	private String email;
	
	private String password;

	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL , orphanRemoval = true)
	@JsonManagedReference
	private List<HealthData> healthData;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL , orphanRemoval = true)
	@JsonManagedReference
	private List<Recommendation> recommendation;
	

}
