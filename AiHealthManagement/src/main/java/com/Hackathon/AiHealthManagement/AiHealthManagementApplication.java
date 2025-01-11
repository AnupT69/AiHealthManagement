package com.Hackathon.AiHealthManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class AiHealthManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(AiHealthManagementApplication.class, args);
	}

}
