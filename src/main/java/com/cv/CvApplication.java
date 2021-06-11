package com.cv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

import com.cv.entities.Utilisateur;
import com.cv.service.FormationService;

@SpringBootApplication
public class CvApplication {

	public static void main(String[] args) {
		SpringApplication.run(CvApplication.class, args);
	}

	
}
