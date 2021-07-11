package com.cv.service.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.never;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.cv.entities.Profile;
import com.cv.entities.Utilisateur;
import com.cv.repository.ProfileRepository;
import com.cv.repository.UtilisateurRepository;
import com.cv.service.ProfileService;


@SpringBootTest

class ProfileServiceTest {

	@Autowired
	ProfileService ps;
	@Autowired
	ProfileRepository pr;
	@Autowired
	UtilisateurRepository ur;
	
	
	@BeforeEach
	void setUp() throws Exception {
		
	}

	@Test
	void testAjouter() {
		Utilisateur u = new Utilisateur();
		u.setNom("mouad");
		ur.save(u);
		Profile profile = new Profile(null,"test",u);
		ps.ajouterProfile(profile, u);
		//Profile exp = pr.save(profile);
		String exp ="test";
		//assertNotNull(ps.getProfile(u));
		assertEquals("test", profile.getProfile());
		assertEquals(exp, profile.getProfile());
	}
	@Test
	void testSupprimer()
	{
		Utilisateur u = new Utilisateur();
		u.setNom("mouad");
		ur.save(u);
		Profile profile = new Profile(2L,"test",u);
		ps.ajouterProfile(profile, u);
		Long id = profile.getId();
		ps.supprimerProfile(id);
		//pr.deleteById(id);
		Profile exp = ps.getProfile(u);
		assertNull(exp);
	}

}
