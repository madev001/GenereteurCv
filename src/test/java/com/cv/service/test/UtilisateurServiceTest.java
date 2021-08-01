package com.cv.service.test;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.Console;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import com.cv.entities.Formation;
import com.cv.entities.Utilisateur;
import com.cv.repository.FormationRepository;
import com.cv.repository.UtilisateurRepository;
import com.cv.service.FormationService;

@RunWith(MockitoJUnitRunner.class)
class UtilisateurServiceTest {
	@Autowired
    FormationRepository fr;
	@Autowired
	UtilisateurRepository ur;
	@Autowired
	FormationService fs;
	
	
	
     
	 
	 
    
	/*@Test
	void testAjoutUtilisateur() {
		
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setNom("test");
		utilisateur.setPrenom("test");
		utilisateur.setAdresse("test");
		utilisateur.setEmail("test");
		Utilisateur saved = ur.save(utilisateur);
		//assertEquals(1, ur.findAll().size());
		assertEquals("test",saved.getNom());
		//when(fr.save(formation)).thenReturn(formation);
		//Formation created = fs.ajouterFormation(formation, null);
		//created.setIntitule(formation.getIntitule());
		
		//assertEquals("qualite logiciel", formation.getIntitule());
		
	}*/

}
