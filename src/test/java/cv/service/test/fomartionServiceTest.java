package cv.service.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;

import com.cv.CvApplication;
import com.cv.entities.Formation;
import com.cv.entities.Utilisateur;
import com.cv.repository.FormationRepository;
import com.cv.repository.UtilisateurRepository;
import com.cv.service.FormationService;

@DataJpaTest
@ContextConfiguration(classes = CvApplication.class) 
@AutoConfigureTestDatabase(replace = Replace.NONE)
class fomartionServiceTest {

	@Autowired
	UtilisateurRepository utilisateurRepository;
	@Autowired
	FormationRepository formationRepository;
	//@Autowired : error creating bean ?
	FormationService formationService;
	
	@BeforeAll
	 static void setUpBeforeClass() throws Exception {
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testAjout() {
		final Utilisateur utilisateur = new Utilisateur();
		utilisateur.setNom("test nom");
		utilisateur.setPrenom("testPrenom");
		utilisateur.setEmail("test@test.test");
		utilisateur.setAdresse("adresse aleatoire");
		utilisateur.setVille("Oujda");
		utilisateur.setCodePostal(17000);
		utilisateur.setDateNaissance(null);
		utilisateur.setImage(null);
		 utilisateurRepository.save(utilisateur);
		 
		final Formation formation = new Formation();
		formation.setDescription("test test test");
		formation.setEtablissement("test test test");
		formation.setFormation_debut_annee("2019");
		formation.setIntitule("test test test");
		formation.setLocalite("test test test");
		formation.setUtilisateur(utilisateur);
		//Formation exepted = formationService.ajouterFormation(formation, utilisateur);
		Formation exepted = formationRepository.save(formation);
		assertNotNull(exepted);
	}

}
