package com.cv.service.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cv.entities.Formation;
import com.cv.entities.Utilisateur;
import com.cv.repository.FormationRepository;
import com.cv.repository.UtilisateurRepository;
import com.cv.service.FormationService;


@SpringBootTest
class FormationServiceTest {
	@Autowired
	FormationService fs;
	@Autowired
	FormationRepository fr;
	@Autowired
	UtilisateurRepository ur;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testAjoutFormation() {
		Utilisateur u = new Utilisateur();
		u.setNom("mouad");
		ur.save(u);
		Formation formation = new Formation();
		formation.setDescription("test");
		formation.setEtablissement("etablissement test");
		Formation exepted =fs.ajouterFormation(formation, u);
		assertEquals("test", exepted.getDescription());

	}
	/*@Test
	void testSuppFormation() {
		Utilisateur u = new Utilisateur();
		u.setNom("mouad");
		ur.save(u);
		Formation formation = new Formation();
		formation.setId(3L);
		formation.setDescription("test");
		formation.setEtablissement("etablissement test");
		fs.ajouterFormation(formation, u);
		List<Formation> exepted = fs.listeFormation(u);	
				assertNotNull(exepted);
		Long id= 3L;
		fs.supprimerFormation(id);
		List<Formation> exepteda = fs.listeFormation(u);	
		assertNotNull(exepteda);

	}*/

}
