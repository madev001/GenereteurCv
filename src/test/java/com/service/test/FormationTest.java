package com.service.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import com.cv.CvApplication;
import com.cv.entities.Formation;
import com.cv.repository.FormationRepository;
import com.cv.service.FormationService;

import antlr.collections.List;

@DataJpaTest
@ContextConfiguration(classes = CvApplication.class) 
@AutoConfigureTestDatabase(replace = Replace.NONE)
class FormationTest {

	@Autowired
	private FormationRepository formationRepository;
	@Test
	public void testCreateFormation() {
		Formation formation = new Formation();
		formation.setIntitule("FormationTest");
		Formation savedFormation = formationRepository.save(formation);
		assertNotNull(savedFormation);
	}
	
	
}
